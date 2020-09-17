package com.viewnext.autoriego.business.service;


import java.util.List;
import java.util.Optional;

import com.viewnext.autoriego.persistence.model.Parcela;


public interface ParcelaService {

	public List<Parcela> getAll();

	public Optional<Parcela> get(int id);

	public Parcela save(Parcela parcela);

}
