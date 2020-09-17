package com.viewnext.autoriego.business.service.impl;

import java.util.Calendar;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import com.viewnext.autoriego.business.service.RiegoService;
import com.viewnext.autoriego.persistence.model.Manguera;
import com.viewnext.autoriego.persistence.model.Parcela;
import com.viewnext.autoriego.persistence.model.Registro;
import com.viewnext.autoriego.persistence.repository.MangueraRepository;
import com.viewnext.autoriego.persistence.repository.ParcelaRepository;
import com.viewnext.autoriego.persistence.repository.RegistroRepository;

@Service
public class RiegoServiceImpl implements RiegoService{

	@Autowired
	private MangueraRepository mangueraRepository;
	
	@Autowired
	private RegistroRepository registroRepository;
	
	@Autowired
	private ParcelaRepository parcelaRepository;
	
	@Async("trheadPoolTaskExecutor")
	public void regar() throws InterruptedException {
		Manguera manguera = this.cogerManguera();
		if (manguera!=null) {
			Parcela parcela = parcelaRepository.findPendiente(Calendar.getInstance());
			while(parcela != null) {
				this.abrirParcela(parcela);
				
				Registro registro = new Registro();
				registro.setManguera(manguera);
				registro.setParcela(parcela);
				registro.setInicio(Calendar.getInstance());
				
				this.regarParcela(parcela,manguera);
				
				registro.setFin(Calendar.getInstance());
				
				registroRepository.save(registro);
				
				this.cerrarParcela(parcela);
				
				parcela = parcelaRepository.findPendiente(Calendar.getInstance());
			}
			this.dejarManguera(manguera);
		}		
	}

	private void abrirParcela(Parcela parcela) {
		parcela.setEnUso(true);
		parcelaRepository.save(parcela);
	}

	private void regarParcela(Parcela parcela, Manguera manguera) throws InterruptedException {
		parcelaRepository.save(parcela);
		double segundos = parcela.getCultivo().getAgua()/manguera.getCaudal();
		Thread.sleep((long) (6000*segundos));
	}

	private void cerrarParcela(Parcela parcela) {
		Calendar finAgua = Calendar.getInstance();
		finAgua.add(Calendar.MINUTE, 5); //a los 5 minutos vuelven a necesitar agua
		parcela.setFinAgua(finAgua);
		parcela.setEnUso(false);
		parcelaRepository.save(parcela);
	}

	private Manguera cogerManguera() {
		Manguera manguera = this.mangueraRepository.findOneByEnUsoFalse();
		if (manguera != null) {
			manguera.setEnUso(true);
			this.mangueraRepository.save(manguera);
		}
		return manguera;
	}
	
	private Manguera dejarManguera(Manguera manguera) {
		
		manguera.setEnUso(false);
		
		return this.mangueraRepository.save(manguera);
	
	}

}
