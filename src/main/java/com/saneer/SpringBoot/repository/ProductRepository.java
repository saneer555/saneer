package com.saneer.SpringBoot.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.saneer.SpringBoot.enity.Product;

public interface ProductRepository extends JpaRepository<Product, Long>{

}
