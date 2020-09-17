package com.viewnext.autoriego.persistence.repository;

import java.util.Calendar;


import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.viewnext.autoriego.persistence.model.Parcela;


public interface ParcelaRepository extends CrudRepository<Parcela, Integer>{

	@Query("select p from Parcela p where p.finAgua < :ahora and p.enUso = false and rownum =1 ")
	public Parcela findPendiente(@Param("ahora") Calendar ahora);

}
