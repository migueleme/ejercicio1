package com.viewnext.autoriego.business.mapper;

import org.mapstruct.Mapper;

import com.viewnext.autoriego.persistence.model.ParcelaEntity;
import com.viewnext.autoriego.view.model.ParcelaDTO;

@Mapper
public interface ParcelaMapper {

	ParcelaDTO parcelaEntityToParcelaDTO(ParcelaEntity parcelaEntity);

	ParcelaEntity parcelaDTOToParcelaEntity(ParcelaDTO parcelaDTO);

}
