package com.viewnext.autoriego.business.service;

import java.util.List;
import java.util.Optional;

import com.viewnext.autoriego.persistence.model.Manguera;

public interface MangueraService {
	public List<Manguera> getAll();

	public Manguera save(Manguera Manguera);

	public Optional<Manguera> get(int id);
}
