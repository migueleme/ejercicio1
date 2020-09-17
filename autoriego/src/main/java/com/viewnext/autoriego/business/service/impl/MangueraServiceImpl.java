package com.viewnext.autoriego.business.service.impl;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.viewnext.autoriego.business.mapper.MangueraMapper;
import com.viewnext.autoriego.business.service.MangueraService;
import com.viewnext.autoriego.persistence.repository.MangueraRepository;
import com.viewnext.autoriego.view.model.MangueraDTO;

@Service
public class MangueraServiceImpl implements MangueraService {

	@Autowired
	private MangueraRepository mangueraRepository;

	private MangueraMapper mangueraMapper = Mappers.getMapper(MangueraMapper.class);

	@Override
	public List<MangueraDTO> getAll() {
		return StreamSupport.stream(mangueraRepository.findAll().spliterator(), false)
				.map(mangueraMapper::mangueraEntityToMangueraDTO).collect(Collectors.toList());
	}

	@Override
	public MangueraDTO save(MangueraDTO manguera) {
		return mangueraMapper.mangueraEntityToMangueraDTO(
				mangueraRepository.save(mangueraMapper.mangueraDTOToMangueraEntity(manguera)));

	}

	@Override
	public Optional<MangueraDTO> get(int id) {
		return mangueraRepository.findById(id).map(mangueraMapper::mangueraEntityToMangueraDTO);
	}

}
