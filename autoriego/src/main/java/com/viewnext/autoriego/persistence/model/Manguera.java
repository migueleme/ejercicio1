package com.viewnext.autoriego.persistence.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Manguera implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue	
	private int idManguera;
	
	private double caudal;
	
	private boolean enUso;
	
	
	public Manguera() {
	}
	
	public int getIdManguera() {
		return idManguera;
	}
	
	public void setIdManguera(int idManguera) {
		this.idManguera = idManguera;
	}
	
	public double getCaudal() {
		return caudal;
	}
	
	public void setCaudal(double caudal) {
		this.caudal = caudal;
	}
	
	public boolean isEnUso() {
		return enUso;
	}
	
	public void setEnUso(boolean enUso) {
		this.enUso = enUso;
	}

	@Override
	public String toString() {
		return "Manguera [idManguera=" + idManguera + ", caudal=" + caudal + ", enUso=" + enUso + "]";
	}
	
	
}
