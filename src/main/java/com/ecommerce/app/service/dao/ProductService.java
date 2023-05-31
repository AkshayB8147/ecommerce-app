package com.ecommerce.app.service.dao;

import com.ecommerce.app.entity.Product;

import java.util.List;

public interface ProductService {

    public List<Product> getAllProducts();

    public List<Product> saveAllProducts(List<Product> products);
}
