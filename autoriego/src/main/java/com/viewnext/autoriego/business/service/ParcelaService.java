package com.viewnext.autoriego.business.service;

import java.util.List;
import java.util.Optional;

import com.viewnext.autoriego.view.model.ParcelaDTO;

public interface ParcelaService {

	public List<ParcelaDTO> getAll();

	public Optional<ParcelaDTO> get(int id);

	public ParcelaDTO save(ParcelaDTO parcela);

}
