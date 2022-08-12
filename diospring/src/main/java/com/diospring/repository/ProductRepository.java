package com.diospring.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.diospring.entity.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long>{

}
