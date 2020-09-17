package com.viewnext.autoriego.business.service.impl;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.viewnext.autoriego.business.mapper.RegistroMapper;
import com.viewnext.autoriego.business.service.RegistroService;
import com.viewnext.autoriego.persistence.repository.RegistroRepository;
import com.viewnext.autoriego.view.model.RegistroDTO;

@Service
public class RegistroServiceImpl implements RegistroService {

	@Autowired
	private RegistroRepository registroRepository;

	private RegistroMapper registroMapper = Mappers.getMapper(RegistroMapper.class);

	@Override
	public List<RegistroDTO> getAll() {
		return StreamSupport.stream(registroRepository.findAll().spliterator(), false)
				.map(registroMapper::registroEntityToRegistroDTO).collect(Collectors.toList());
	}

	@Override
	public RegistroDTO save(RegistroDTO registro) {
		return registroMapper.registroEntityToRegistroDTO(
				registroRepository.save(registroMapper.registroDTOToRegistroEntity(registro)));

	}

	@Override
	public Optional<RegistroDTO> get(int id) {
		return registroRepository.findById(id).map(registroMapper::registroEntityToRegistroDTO);
	}
}
