package com.viewnext.autoriego.business.service;

import java.util.List;
import java.util.Optional;

import com.viewnext.autoriego.view.model.CultivoDTO;

/**
 * Servicio que se encarga de gestionar los cultivos
 * 
 * @author 0017011
 *
 */
public interface CultivoService {

	public List<CultivoDTO> getAll();

	public CultivoDTO save(CultivoDTO cultivo);

	public Optional<CultivoDTO> get(String id);

}
