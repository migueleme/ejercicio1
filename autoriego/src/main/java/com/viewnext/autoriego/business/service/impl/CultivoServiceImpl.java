package com.viewnext.autoriego.business.service.impl;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.viewnext.autoriego.business.service.CultivoService;
import com.viewnext.autoriego.persistence.model.Cultivo;
import com.viewnext.autoriego.persistence.repository.CultivoRepository;

@Service
public class CultivoServiceImpl implements CultivoService{

	@Autowired
	CultivoRepository cultivoRepository;

	@Override
	public List<Cultivo> getAll() {
		return StreamSupport.stream(cultivoRepository.findAll().spliterator(), false).collect(Collectors.toList());
	}

	@Override
	public Optional<Cultivo> get(String id) {
		return cultivoRepository.findById(id);
	}

	@Override
	public Cultivo save(Cultivo cultivo) {
		return this.cultivoRepository.save(cultivo);
	}

}
