package com.diospring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.diospring.entity.Product;
import com.diospring.exception.ProductNullException;
import com.diospring.exception.ProductPriceException;
import com.diospring.repository.ProductRepository;

@Service
public class ProductService {

	@Autowired
	private ProductRepository repository;

	public Product save(Product product) throws Exception {
		if (product.getName() == null || product.getPrice()==null)
			throw new ProductNullException();
		if (product.getPrice()<=0)
			throw new ProductPriceException();		
		
		return repository.save(product);
	}

	public Product findById(Long id) {
		return repository.findById(id).orElse(null);
	}

	public List<Product> findAll() {
		return repository.findAll();
	}

}
