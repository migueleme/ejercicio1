package com.viewnext.autoriego.view;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.viewnext.autoriego.business.service.RegistroService;
import com.viewnext.autoriego.persistence.model.Registro;

@RestController
@RequestMapping("registro")
public class RegistroController {
	@Autowired
	RegistroService registroService;
	
	@GetMapping
	public ResponseEntity<List<Registro>> obtenerRegistro(){
		ResponseEntity<List<Registro>> responseEntity;
		try{
			responseEntity = new ResponseEntity<List<Registro>>(registroService.getAll(), HttpStatus.OK);
		}catch(Exception e){
			responseEntity = new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return responseEntity;
	}
}
