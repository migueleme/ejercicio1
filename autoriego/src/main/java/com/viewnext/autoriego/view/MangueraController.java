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
import com.viewnext.autoriego.view.model.MangueraDTO;

@RestController
@RequestMapping("manguera")
public class MangueraController {

	@Autowired
	private MangueraService mangueraService;

	@GetMapping
	public ResponseEntity<List<MangueraDTO>> getAll() {
		ResponseEntity<List<MangueraDTO>> responseEntity;
		try {
			responseEntity = new ResponseEntity<List<MangueraDTO>>(mangueraService.getAll(), HttpStatus.OK);
		} catch (Exception e) {
			responseEntity = new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return responseEntity;
	}

	@GetMapping("/{id}")
	public ResponseEntity<MangueraDTO> get(@PathVariable int id) {
		ResponseEntity<MangueraDTO> responseEntity;
		try {
			responseEntity = new ResponseEntity<MangueraDTO>(mangueraService.get(id).get(), HttpStatus.OK);
		} catch (Exception e) {
			responseEntity = new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return responseEntity;
	}

	@PostMapping
	public ResponseEntity<MangueraDTO> post(MangueraDTO Manguera) {
		ResponseEntity<MangueraDTO> responseEntity;
		try {
			responseEntity = new ResponseEntity<MangueraDTO>(mangueraService.save(Manguera), HttpStatus.OK);
		} catch (Exception e) {
			responseEntity = new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return responseEntity;
	}
}
