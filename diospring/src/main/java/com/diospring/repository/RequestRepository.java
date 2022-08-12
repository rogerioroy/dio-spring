package com.diospring.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.diospring.entity.Request;

@Repository
public interface RequestRepository extends JpaRepository<Request, Long>{

}
