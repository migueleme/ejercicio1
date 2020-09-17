package com.viewnext.autoriego.persistence.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.viewnext.autoriego.persistence.model.Manguera;

public interface MangueraRepository extends CrudRepository<Manguera, Integer>{
	@Query("select m from Manguera m where m.enUso = false and rownum =1 ")
	public Manguera findOneByEnUsoFalse();

}
