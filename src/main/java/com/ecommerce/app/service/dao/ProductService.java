package com.ecommerce.app.service.dao;

import com.ecommerce.app.entity.Product;
import com.ecommerce.app.exceptions.ProductNotPresentException;

import java.util.List;

public interface ProductService {

    public List<Product> getAllProducts();

    public List<Product> saveAllProducts(List<Product> products);

    public Product getProductById(Long productId) throws ProductNotPresentException;

    public Product saveProduct(Product product);

    public Product updateProduct(Long productId, Product product);
}
