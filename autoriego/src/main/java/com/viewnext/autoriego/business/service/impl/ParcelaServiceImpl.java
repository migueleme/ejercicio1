package com.viewnext.autoriego.business.service.impl;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import org.springframework.stereotype.Service;

import com.viewnext.autoriego.business.service.ParcelaService;
import com.viewnext.autoriego.persistence.model.Parcela;
import com.viewnext.autoriego.persistence.repository.ParcelaRepository;
@Service
public class ParcelaServiceImpl implements ParcelaService{
	
	private ParcelaRepository parcelaRepository;


	@Override
	public List<Parcela> getAll() {
		return StreamSupport.stream(parcelaRepository.findAll().spliterator(), false).collect(Collectors.toList());
	}

	@Override
	public Optional<Parcela> get(int id) {
		return parcelaRepository.findById(id);
	}

	@Override
	public Parcela save(Parcela parcela) {
		return this.parcelaRepository.save(parcela);
	}

}
