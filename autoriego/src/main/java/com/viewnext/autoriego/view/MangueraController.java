package com.viewnext.autoriego.view;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.viewnext.autoriego.business.service.MangueraService;
import com.viewnext.autoriego.persistence.model.Manguera;

@RestController
@RequestMapping("manguera")
public class MangueraController {
	@Autowired
	MangueraService mangueraService;
	@GetMapping
	ResponseEntity<List<Manguera>> getAll(){
		ResponseEntity<List<Manguera>> responseEntity;
		try{
			responseEntity = new ResponseEntity<List<Manguera>>(mangueraService.getAll(), HttpStatus.OK);
		}catch(Exception e){
			responseEntity = new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return responseEntity;
	}
	@GetMapping("/{id}")
	ResponseEntity<Manguera> get(@PathVariable int id){
		ResponseEntity<Manguera> responseEntity;
		try{
			responseEntity = new ResponseEntity<Manguera>(mangueraService.get(id).get(), HttpStatus.OK);
		}catch(Exception e){
			responseEntity = new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return responseEntity;
	}
	@PostMapping
	ResponseEntity<Manguera> post(Manguera Manguera){
		ResponseEntity<Manguera> responseEntity;
		try{
			responseEntity = new ResponseEntity<Manguera>(mangueraService.save(Manguera), HttpStatus.OK);
		}catch(Exception e){
			responseEntity = new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return responseEntity;
	}
}
