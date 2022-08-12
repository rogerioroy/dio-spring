package com.diospring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.diospring.entity.Request;
import com.diospring.service.RequestService;

@RestController
@RequestMapping(value = "/request")
public class RequestController {

	@Autowired
	private RequestService service;

	@PostMapping(value = "/save")
	public ResponseEntity<Request> saveProduct(@RequestBody Request product) {

		product = service.save(product);
		
		return ResponseEntity.ok().body(product);
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<Request> searchProduct(@PathVariable Long id) {
		
		Request request = service.findById(id); 
		
		return ResponseEntity.ok().body(request);
	}
	
	@GetMapping(value = "/search-all")
	public ResponseEntity<List<Request>> searchAllProducts(){
		
		List<Request> request = service.findAll();
		
		return ResponseEntity.ok().body(request);
	}
	
}
