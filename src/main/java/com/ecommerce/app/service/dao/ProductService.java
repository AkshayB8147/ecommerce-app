package com.ecommerce.app.service.dao;

import com.ecommerce.app.dto.product.ProductDto;
import com.ecommerce.app.entity.Category;
import com.ecommerce.app.entity.Product;

import java.util.List;

public interface ProductService {

    List<ProductDto> getAllProducts();

    void saveProduct(ProductDto productDtoRequest, Category category);

    Product getProductById(Long productId);

    void updateProduct(Long productId, ProductDto productDto, Category category);

}
