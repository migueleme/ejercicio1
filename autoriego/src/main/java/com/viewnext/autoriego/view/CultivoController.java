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
import com.viewnext.autoriego.view.model.CultivoDTO;

@RestController
@RequestMapping("cultivo")
public class CultivoController {

	@Autowired
	private CultivoService cultivoService;

	@GetMapping
	public ResponseEntity<List<CultivoDTO>> getAll() {
		ResponseEntity<List<CultivoDTO>> responseEntity;
		try {
			responseEntity = new ResponseEntity<>(cultivoService.getAll(), HttpStatus.OK);
		} catch (Exception e) {
			responseEntity = new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return responseEntity;
	}

	@GetMapping("/{id}")
	public ResponseEntity<CultivoDTO> get(@PathVariable String id) {
		ResponseEntity<CultivoDTO> responseEntity;
		try {
			responseEntity = new ResponseEntity<>(cultivoService.get(id).orElse(new CultivoDTO()), HttpStatus.OK);
		} catch (Exception e) {
			responseEntity = new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return responseEntity;
	}

	@PostMapping
	public ResponseEntity<CultivoDTO> post(CultivoDTO cultivo) {
		ResponseEntity<CultivoDTO> responseEntity;
		try {
			responseEntity = new ResponseEntity<>(cultivoService.save(cultivo), HttpStatus.OK);
		} catch (Exception e) {
			responseEntity = new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return responseEntity;
	}
}
