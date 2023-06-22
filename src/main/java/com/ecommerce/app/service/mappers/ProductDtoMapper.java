package com.ecommerce.app.service.mappers;

import com.ecommerce.app.dto.product.ProductDto;
import com.ecommerce.app.entity.Product;
import org.springframework.stereotype.Service;

import java.util.function.Function;

@Service
public class ProductDtoMapper implements Function<Product, ProductDto> {

    @Override
    public ProductDto apply(Product product) {
        return new ProductDto(
                product.getProductId(),
                product.getName(),
                product.getPrice(),
                product.getDescription(),
                product.getImageUrl(),
                product.getCategory().getCategoryId()
        );
    }
}
