package com.viewnext.autoriego.business.process;

import java.util.Calendar;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

import com.viewnext.autoriego.persistence.model.MangueraEntity;
import com.viewnext.autoriego.persistence.model.ParcelaEntity;
import com.viewnext.autoriego.persistence.model.RegistroEntity;
import com.viewnext.autoriego.persistence.repository.MangueraRepository;
import com.viewnext.autoriego.persistence.repository.ParcelaRepository;
import com.viewnext.autoriego.persistence.repository.RegistroRepository;
@Component
public class ProcesoRiego {

	@Autowired
	private MangueraRepository mangueraRepository;

	@Autowired
	private RegistroRepository registroRepository;

	@Autowired
	private ParcelaRepository parcelaRepository;

	@Async("trheadPoolTaskExecutor")
	public void regar() throws InterruptedException {
		MangueraEntity manguera = this.cogerManguera();
		if (manguera != null) {
			ParcelaEntity parcela = parcelaRepository.findPendiente(Calendar.getInstance());
			while (parcela != null) {
				this.abrirParcela(parcela);

				RegistroEntity registro = new RegistroEntity();
				registro.setManguera(manguera);
				registro.setParcela(parcela);
				registro.setInicio(Calendar.getInstance());

				this.regarParcela(parcela, manguera);

				registro.setFin(Calendar.getInstance());

				registroRepository.save(registro);

				this.cerrarParcela(parcela);

				parcela = parcelaRepository.findPendiente(Calendar.getInstance());
			}
			this.dejarManguera(manguera);
		}
	}

	private void abrirParcela(ParcelaEntity parcela) {
		parcela.setEnUso(true);
		parcelaRepository.save(parcela);
	}

	private void regarParcela(ParcelaEntity parcela, MangueraEntity manguera) throws InterruptedException {
		parcelaRepository.save(parcela);
		double segundos = parcela.getCultivo().getAgua() / manguera.getCaudal();
		Thread.sleep((long) (6000 * segundos));
	}

	private void cerrarParcela(ParcelaEntity parcela) {
		Calendar finAgua = Calendar.getInstance();
		finAgua.add(Calendar.MINUTE, 5); // a los 5 minutos vuelven a necesitar agua
		parcela.setFinAgua(finAgua);
		parcela.setEnUso(false);
		parcelaRepository.save(parcela);
	}

	private MangueraEntity cogerManguera() {
		MangueraEntity manguera = this.mangueraRepository.findOneByEnUsoFalse();
		if (manguera != null) {
			manguera.setEnUso(true);
			this.mangueraRepository.save(manguera);
		}
		return manguera;
	}

	private MangueraEntity dejarManguera(MangueraEntity manguera) {

		manguera.setEnUso(false);

		return this.mangueraRepository.save(manguera);
	}
}
