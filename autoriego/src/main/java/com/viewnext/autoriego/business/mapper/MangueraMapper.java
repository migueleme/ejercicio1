package com.viewnext.autoriego.business.mapper;

import org.mapstruct.Mapper;

import com.viewnext.autoriego.persistence.model.MangueraEntity;
import com.viewnext.autoriego.view.model.MangueraDTO;

@Mapper
public interface MangueraMapper {

	MangueraDTO mangueraEntityToMangueraDTO(MangueraEntity mangueraEntity);

	MangueraEntity mangueraDTOToMangueraEntity(MangueraDTO mangueraDTO);
}
