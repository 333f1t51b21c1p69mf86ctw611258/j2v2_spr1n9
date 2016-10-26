package com.frameworkonly.webapp.repository;

import org.springframework.data.repository.CrudRepository;

import com.frameworkonly.webapp.domain.Product;

public interface ProductRepository extends CrudRepository<Product, Integer>{
}
