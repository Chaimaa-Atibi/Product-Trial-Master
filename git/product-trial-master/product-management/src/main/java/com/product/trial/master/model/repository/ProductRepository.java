package com.product.trial.master.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.product.trial.master.model.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {

}
