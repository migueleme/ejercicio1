package com.viewnext.autoriego.business.service;

import java.util.List;
import java.util.Optional;

import com.viewnext.autoriego.persistence.model.Cultivo;

/**
 * Servicio que se encarga de gestionar los cultivos
 * @author 0017011
 *
 */
public interface CultivoService {

	public List<Cultivo> getAll();

	public Cultivo save(Cultivo Cultivo);

	public Optional<Cultivo> get(String id);

}
