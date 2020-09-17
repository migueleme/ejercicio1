package com.viewnext.autoriego.business.service.impl;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.viewnext.autoriego.business.mapper.ParcelaMapper;
import com.viewnext.autoriego.business.service.ParcelaService;
import com.viewnext.autoriego.persistence.repository.ParcelaRepository;
import com.viewnext.autoriego.view.model.ParcelaDTO;

@Service
public class ParcelaServiceImpl implements ParcelaService {

	@Autowired
	private ParcelaRepository parcelaRepository;

	private ParcelaMapper parcelaMapper = Mappers.getMapper(ParcelaMapper.class);

	@Override
	public List<ParcelaDTO> getAll() {
		return StreamSupport.stream(parcelaRepository.findAll().spliterator(), false)
				.map(parcelaMapper::parcelaEntityToParcelaDTO).collect(Collectors.toList());
	}

	@Override
	public ParcelaDTO save(ParcelaDTO parcela) {
		return parcelaMapper
				.parcelaEntityToParcelaDTO(parcelaRepository.save(parcelaMapper.parcelaDTOToParcelaEntity(parcela)));

	}

	@Override
	public Optional<ParcelaDTO> get(int id) {
		return parcelaRepository.findById(id).map(parcelaMapper::parcelaEntityToParcelaDTO);
	}
}
