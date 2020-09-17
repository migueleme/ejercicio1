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
public class Registro implements Serializable{
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue
	private int idRegistro;
	
	@ManyToOne
	private Manguera Manguera;
	
	@Temporal(TemporalType.TIMESTAMP)
	private Calendar inicio;
	
	@Temporal(TemporalType.TIMESTAMP)
	private Calendar fin;
	
	@ManyToOne
	private Parcela parcela;
	
	public Registro() {
	}

	public int getIdRegistro() {
		return idRegistro;
	}

	public void setIdRegistro(int idRegistro) {
		this.idRegistro = idRegistro;
	}



	public Manguera getManguera() {
		return Manguera;
	}

	public void setManguera(Manguera manguera) {
		Manguera = manguera;
	}

	public Calendar getInicio() {
		return inicio;
	}

	public void setInicio(Calendar inicio) {
		this.inicio = inicio;
	}

	public Calendar getFin() {
		return fin;
	}

	public void setFin(Calendar fin) {
		this.fin = fin;
	}

	public Parcela getParcela() {
		return parcela;
	}

	public void setParcela(Parcela parcela) {
		this.parcela = parcela;
	}
	
	

}
