package com.diospring.entity;

import java.time.LocalDateTime;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

@Entity
public class Request {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private Long address;
	private LocalDateTime dateRequest;
	private String status;
	
	
	@ManyToMany
	@Fetch(FetchMode.SELECT)
	private Set<Product> products;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Long getAddress() {
		return address;
	}
	public void setAddress(Long address) {
		this.address = address;
	}
	public LocalDateTime getDateRequest() {
		return dateRequest;
	}
	public void setDateRequest(LocalDateTime dateRequest) {
		this.dateRequest = dateRequest;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	
	public Set<Product> getProducts() {
		return products;
	}
	
	public void setProducts (Set<Product> products) {
		this.products = products;
	}
	
}
