package com.viewnext.autoriego.persistence.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Data;

@Data
@Entity
public class CultivoEntity implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	private String tipo;

	private int agua;

}
