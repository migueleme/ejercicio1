package com.viewnext.autoriego.persistence.model;

import java.io.Serializable;
import java.util.Calendar;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.Data;

@Data
@Entity
public class RegistroEntity implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue
	private int idRegistro;

	@ManyToOne
	private MangueraEntity manguera;

	@Temporal(TemporalType.TIMESTAMP)
	private Calendar inicio;

	@Temporal(TemporalType.TIMESTAMP)
	private Calendar fin;

	@ManyToOne
	private ParcelaEntity parcela;

}
