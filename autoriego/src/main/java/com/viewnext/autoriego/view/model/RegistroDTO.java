package com.viewnext.autoriego.view.model;

import java.io.Serializable;
import java.util.Calendar;

import lombok.Data;

@Data
public class RegistroDTO implements Serializable {

	private static final long serialVersionUID = 1L;
	private int idRegistro;
	private MangueraDTO manguera;
	private Calendar inicio;
	private Calendar fin;
	private ParcelaDTO parcela;

}
