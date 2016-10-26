package com.frameworkonly.webapp.service;


import com.frameworkonly.webapp.domain.Product;

public interface ProductService {
    Iterable<Product> listAllProducts();

    Product getProductById(Integer id);

    Product saveProduct(Product product);
}
