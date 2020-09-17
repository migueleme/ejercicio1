package com.viewnext.autoriego.business.service.impl;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.viewnext.autoriego.business.service.MangueraService;
import com.viewnext.autoriego.persistence.model.Manguera;
import com.viewnext.autoriego.persistence.repository.MangueraRepository;

@Service
public class MangueraServiceImpl implements MangueraService {
	@Autowired
	MangueraRepository mangueraRepository;

	@Override
	public List<Manguera> getAll() {
		return StreamSupport.stream(mangueraRepository.findAll().spliterator(), false).collect(Collectors.toList());
	}

	@Override
	public Manguera save(Manguera manguera) {
		return this.mangueraRepository.save(manguera);
	}

	@Override
	public Optional<Manguera> get(int id) {
		return mangueraRepository.findById(id);
	}
}
