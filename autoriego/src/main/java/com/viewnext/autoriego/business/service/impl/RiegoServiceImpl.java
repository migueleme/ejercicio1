package com.viewnext.autoriego.business.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.viewnext.autoriego.business.process.ProcesoRiego;
import com.viewnext.autoriego.business.service.RiegoService;

@Service
public class RiegoServiceImpl implements RiegoService {

	@Autowired
	private ProcesoRiego procesoRiego;

	@Override
	public void regar() throws InterruptedException {
		procesoRiego.regar();
	}
}
