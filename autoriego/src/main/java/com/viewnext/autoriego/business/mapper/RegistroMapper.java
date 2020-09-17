package com.viewnext.autoriego.business.mapper;

import org.mapstruct.Mapper;

import com.viewnext.autoriego.persistence.model.RegistroEntity;
import com.viewnext.autoriego.view.model.RegistroDTO;

@Mapper
public interface RegistroMapper {

	public RegistroDTO registroEntityToRegistroDTO(RegistroEntity registroEntity);

	public RegistroEntity registroDTOToRegistroEntity(RegistroDTO registroDTO);

}
