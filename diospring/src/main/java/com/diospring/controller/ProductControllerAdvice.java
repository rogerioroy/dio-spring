package com.diospring.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.diospring.exception.ProductNullException;
import com.diospring.exception.ProductPriceException;

@ControllerAdvice
public class ProductControllerAdvice extends ResponseEntityExceptionHandler{

	@ExceptionHandler(ProductNullException.class)
	public ResponseEntity<Object> catchErrorNull(){
		
		Map<String, Object> body = new HashMap<String, Object>();
		
		body.put("message", " Verifique os campos do produto");

		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(body);	}
	
	@ExceptionHandler(ProductPriceException.class)
	public ResponseEntity<Object> catchErrorPrice(){
		
		Map<String, Object> body = new HashMap<String, Object>();
		
		body.put("message", " Verifique o valor do Produto");

		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(body);	}
	
}
