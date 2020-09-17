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

import com.viewnext.autoriego.business.service.ParcelaService;
import com.viewnext.autoriego.persistence.model.Parcela;

@RestController
@RequestMapping("parcela")
public class ParcelaController {
	@Autowired
	ParcelaService parcelaService;
	@GetMapping
	ResponseEntity<List<Parcela>> getAll(){
		ResponseEntity<List<Parcela>> responseEntity;
		try{
			responseEntity = new ResponseEntity<List<Parcela>>(parcelaService.getAll(), HttpStatus.OK);
		}catch(Exception e){
			responseEntity = new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return responseEntity;
	}
	@GetMapping("/{id}")
	ResponseEntity<Parcela> get(@PathVariable int id){
		ResponseEntity<Parcela> responseEntity;
		try{
			responseEntity = new ResponseEntity<Parcela>(parcelaService.get(id).get(), HttpStatus.OK);
		}catch(Exception e){
			responseEntity = new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return responseEntity;
	}
	@PostMapping
	ResponseEntity<Parcela> post(Parcela parcela){
		ResponseEntity<Parcela> responseEntity;
		try{
			responseEntity = new ResponseEntity<Parcela>(parcelaService.save(parcela), HttpStatus.OK);
		}catch(Exception e){
			responseEntity = new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return responseEntity;
	}

}
