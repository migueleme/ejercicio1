package com.viewnext.autoriego.business.service;

import java.util.List;
import java.util.Optional;

import com.viewnext.autoriego.view.model.MangueraDTO;

public interface MangueraService {

	public MangueraDTO save(MangueraDTO manguera);

	public Optional<MangueraDTO> get(int id);

	public List<MangueraDTO> getAll();
}
