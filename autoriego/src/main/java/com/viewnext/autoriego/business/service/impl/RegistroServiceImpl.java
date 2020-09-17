package com.viewnext.autoriego.business.service.impl;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.viewnext.autoriego.business.service.RegistroService;
import com.viewnext.autoriego.persistence.model.Registro;
import com.viewnext.autoriego.persistence.repository.RegistroRepository;

@Service
public class RegistroServiceImpl implements RegistroService{

	@Autowired
	RegistroRepository registroRepository;
	
	@Override
	public List<Registro> getAll() {
		return StreamSupport.stream(registroRepository.findAll().spliterator(), false).collect(Collectors.toList());
	}
}
