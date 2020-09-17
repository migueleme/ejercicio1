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
import com.viewnext.autoriego.view.model.ParcelaDTO;

@RestController
@RequestMapping("parcela")
public class ParcelaController {

	@Autowired
	private ParcelaService parcelaService;

	@GetMapping
	public ResponseEntity<List<ParcelaDTO>> getAll() {
		ResponseEntity<List<ParcelaDTO>> responseEntity;
		try {
			responseEntity = new ResponseEntity<>(parcelaService.getAll(), HttpStatus.OK);
		} catch (Exception e) {
			responseEntity = new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return responseEntity;
	}

	@GetMapping("/{id}")
	public ResponseEntity<ParcelaDTO> get(@PathVariable int id) {
		ResponseEntity<ParcelaDTO> responseEntity;
		try {
			responseEntity = new ResponseEntity<>(parcelaService.get(id).orElse(new ParcelaDTO()), HttpStatus.OK);
		} catch (Exception e) {
			responseEntity = new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return responseEntity;
	}

	@PostMapping
	public ResponseEntity<ParcelaDTO> post(ParcelaDTO parcela) {
		ResponseEntity<ParcelaDTO> responseEntity;
		try {
			responseEntity = new ResponseEntity<>(parcelaService.save(parcela), HttpStatus.OK);
		} catch (Exception e) {
			responseEntity = new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return responseEntity;
	}

}
