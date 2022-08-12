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

import com.diospring.entity.Product;
import com.diospring.service.ProductService;

@RestController
@RequestMapping(value = "/product")
public class ProductController {

	@Autowired
	private ProductService service;
	
	@PostMapping(value = "/save")
	public ResponseEntity<Product> saveProduct(@RequestBody Product product) throws Exception {
		
		product = service.save(product);
		
		return ResponseEntity.ok().body(product);
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<Product> searchProduct(@PathVariable Long id) {
		
		Product product = service.findById(id);
		
		return ResponseEntity.ok().body(product);
	}
	
	@GetMapping(value = "/search-all")
	public ResponseEntity<List<Product>> searchAllProduct() {
		
		List<Product> products = service.findAll();
		
		return ResponseEntity.ok().body(products);
	}
}
