package com.viewnext.autoriego.view.model;

import java.io.Serializable;

import lombok.Data;

@Data
public class MangueraDTO implements Serializable {

	private static final long serialVersionUID = 1L;
	private int idManguera;
	private double caudal;
	private boolean enUso;

}
