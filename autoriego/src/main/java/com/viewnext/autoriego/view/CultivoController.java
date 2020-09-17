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

import com.viewnext.autoriego.business.service.CultivoService;
import com.viewnext.autoriego.persistence.model.Cultivo;

@RestController
@RequestMapping("cultivo")
public class CultivoController {
	@Autowired
	CultivoService cultivoService;
	@GetMapping
	ResponseEntity<List<Cultivo>> getAll(){
		ResponseEntity<List<Cultivo>> responseEntity;
		try{
			responseEntity = new ResponseEntity<List<Cultivo>>(cultivoService.getAll(), HttpStatus.OK);
		}catch(Exception e){
			responseEntity = new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return responseEntity;
	}
	@GetMapping("/{id}")
	ResponseEntity<Cultivo> get(@PathVariable String id){
		ResponseEntity<Cultivo> responseEntity;
		try{
			responseEntity = new ResponseEntity<Cultivo>(cultivoService.get(id).get(), HttpStatus.OK);
		}catch(Exception e){
			responseEntity = new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return responseEntity;
	}
	@PostMapping
	ResponseEntity<Cultivo> post(Cultivo Cultivo){
		ResponseEntity<Cultivo> responseEntity;
		try{
			responseEntity = new ResponseEntity<Cultivo>(cultivoService.save(Cultivo), HttpStatus.OK);
		}catch(Exception e){
			responseEntity = new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return responseEntity;
	}
}
