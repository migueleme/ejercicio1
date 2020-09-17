package com.viewnext.autoriego.view.model;

import java.io.Serializable;
import java.util.Calendar;

import lombok.Data;

@Data
public class ParcelaDTO implements Serializable {

	private static final long serialVersionUID = 1L;
	private int idParcela;
	private CultivoDTO cultivo;
	private Calendar finAgua;
	private boolean enUso;

}
