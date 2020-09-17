package com.viewnext.autoriego.view.model;

import java.io.Serializable;

import lombok.Data;

@Data
public class CultivoDTO implements Serializable {

	private static final long serialVersionUID = 1L;
	private String tipo;
	private int agua;
}
