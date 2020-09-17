package com.viewnext.autoriego.view;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.viewnext.autoriego.business.service.RiegoService;



@RestController
@RequestMapping("/riego")
public class RiegoController {
	
	@Autowired
	private RiegoService riegoService;


	@GetMapping("/regar")
	public ResponseEntity<String> regar() {
		ResponseEntity<String> responseEntity;
		try {
			riegoService.regar();
			responseEntity = new ResponseEntity<String>("Robot comenzó a regar",HttpStatus.OK);
		}catch(Exception e) {
			responseEntity = new ResponseEntity<String>("Error",HttpStatus.INTERNAL_SERVER_ERROR);
			System.out.println(e);
		}
		return responseEntity;
	}
}
