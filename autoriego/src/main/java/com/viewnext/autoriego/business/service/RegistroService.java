package com.viewnext.autoriego.business.service;

import java.util.List;
import java.util.Optional;

import com.viewnext.autoriego.view.model.RegistroDTO;

public interface RegistroService {

	List<RegistroDTO> getAll();

	RegistroDTO save(RegistroDTO registro);

	Optional<RegistroDTO> get(int id);

}
