package com.viewnext.autoriego.persistence.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.viewnext.autoriego.persistence.model.MangueraEntity;

public interface MangueraRepository extends CrudRepository<MangueraEntity, Integer> {

	@Query("select m from Manguera m where m.enUso = false and rownum =1 ")
	public MangueraEntity findOneByEnUsoFalse();

}
