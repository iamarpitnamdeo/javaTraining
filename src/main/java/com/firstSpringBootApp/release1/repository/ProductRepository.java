package com.firstSpringBootApp.release1.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.firstSpringBootApp.release1.model.Product;

public interface ProductRepository extends JpaRepository<Product, String>{

}
