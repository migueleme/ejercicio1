package com.viewnext.autoriego.business.mapper;

import org.mapstruct.Mapper;

import com.viewnext.autoriego.persistence.model.CultivoEntity;
import com.viewnext.autoriego.view.model.CultivoDTO;

@Mapper
public interface CultivoMapper {

	CultivoDTO cultivoEntityToCultivoDTO(CultivoEntity cultivoEntity);

	CultivoEntity cultivoDTOToCultivoEntity(CultivoDTO cultivoDTO);
}
