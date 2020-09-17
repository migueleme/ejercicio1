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
public class ParcelaEntity implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue
	private int idParcela;

	@ManyToOne
	private CultivoEntity cultivo;

	@Temporal(TemporalType.TIMESTAMP)
	private Calendar finAgua;

	private boolean enUso;

}
