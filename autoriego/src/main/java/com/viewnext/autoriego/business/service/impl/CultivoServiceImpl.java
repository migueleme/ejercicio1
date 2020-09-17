package com.viewnext.autoriego.business.service.impl;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.viewnext.autoriego.business.mapper.CultivoMapper;
import com.viewnext.autoriego.business.service.CultivoService;
import com.viewnext.autoriego.persistence.repository.CultivoRepository;
import com.viewnext.autoriego.view.model.CultivoDTO;

@Service
public class CultivoServiceImpl implements CultivoService{

	@Autowired
	private CultivoRepository cultivoRepository;
	
	private CultivoMapper cultivoMapper = Mappers.getMapper(CultivoMapper.class);

	@Override
	public List<CultivoDTO> getAll() {
		return StreamSupport.stream(cultivoRepository.findAll().spliterator(), false)
				.map(cultivoMapper::cultivoEntityToCultivoDTO)
				.collect(Collectors.toList());
	}

	@Override
	public Optional<CultivoDTO> get(String id) {
		return cultivoRepository.findById(id)
				.map(cultivoMapper::cultivoEntityToCultivoDTO);
	}

	@Override
	public CultivoDTO save(CultivoDTO cultivo) {
		return cultivoMapper.cultivoEntityToCultivoDTO(
				cultivoRepository.save(
						cultivoMapper.cultivoDTOToCultivoEntity(
								cultivo)));
	}

}
