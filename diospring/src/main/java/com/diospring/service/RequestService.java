package com.diospring.service;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.diospring.entity.Product;
import com.diospring.entity.Request;
import com.diospring.repository.ProductRepository;
import com.diospring.repository.RequestRepository;

@Service
public class RequestService {

	@Autowired
	private RequestRepository repository;

	@Autowired
	private ProductRepository productRepository;

	public Request save(Request request) {
		Set<Product> products = new HashSet<>();

		request.setDateRequest(LocalDateTime.now());
		request.getProducts().forEach(product -> {
			products.add(productRepository.getById(product.getId()));
		});

		request.setProducts(products);

		return repository.save(request);
	}

	public Request findById(Long id) {
		return repository.findById(id).orElse(null);
	}

	public List<Request> findAll() {
		return repository.findAll();
	}

}
