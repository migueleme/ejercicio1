package com.viewnext.autoriego.persistence.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Cultivo implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Id
	private String tipo;
	
	private int agua;

	public Cultivo() {
	}
	
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	public int getAgua() {
		return agua;
	}
	public void setAgua(int agua) {
		this.agua = agua;
	}

	@Override
	public String toString() {
		return "Cultivo [tipo=" + tipo + ", agua=" + agua + "]";
	}
	
	
}
