package com.viewnext.autoriego.persistence.model;

import java.io.Serializable;
import java.util.Calendar;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Parcela implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue
	private int idParcela;
	
	@ManyToOne
	private Cultivo cultivo;
	
	@Temporal(TemporalType.TIMESTAMP)
	private Calendar finAgua;
	
	private boolean enUso;
	
	
	public Parcela() {
	
	}

	public int getIdParcela() {
		return idParcela;
	}

	public void setIdParcela(int idParcela) {
		this.idParcela = idParcela;
	}

	public Cultivo getCultivo() {
		return cultivo;
	}

	public void setCultivo(Cultivo cultivo) {
		this.cultivo = cultivo;
	}

	public Calendar getFinAgua() {
		return finAgua;
	}

	public void setFinAgua(Calendar finAgua) {
		this.finAgua = finAgua;
	}


	public boolean isEnUso() {
		return enUso;
	}

	public void setEnUso(boolean enUso) {
		this.enUso = enUso;
	}

	@Override
	public String toString() {
		return "Parcela [idParcela=" + idParcela + ", cultivo=" + cultivo + ", finAgua=" + finAgua + ", enUso=" + enUso
				+ "]";
	}
	
	
}
