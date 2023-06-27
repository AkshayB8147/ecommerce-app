package com.ecommerce.app.service;

import com.ecommerce.app.dto.product.ProductDto;
import com.ecommerce.app.entity.Category;
import com.ecommerce.app.entity.Product;
import com.ecommerce.app.exceptions.ResourceNotFoundException;
import com.ecommerce.app.repository.ProductRepository;
import com.ecommerce.app.service.dao.ProductService;
import com.ecommerce.app.service.mappers.ProductDtoMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
public class ProductServiceImpl implements ProductService {
    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private ProductDtoMapper productDtoMapper;

    @Override
    public List<ProductDto> getAllProducts() {
        return productRepository.findAll()
                .stream()
                .map(productDtoMapper)
                .collect(Collectors.toList());
    }

    @Override
    public void saveProduct(ProductDto productDtoRequest, Category category) {
        Product productToSave = new Product(productDtoRequest, category);
        log.info("Saved Product :{}", productRepository.save(productToSave));
    }

    @Override
    public Product getProductById(Long productId) throws ResourceNotFoundException{
        return productRepository.findById(productId)
                .orElseThrow(() -> new ResourceNotFoundException("Product", "id", productId));
    }

    @Override
    public void updateProduct(Long productId, ProductDto productDto, Category category) throws ResourceNotFoundException {
        if(
                !productRepository.existsById(productId) ||
                        (!productId.equals(productDto.getProductId()) && productDto.getProductId() != null)
        ) {
            throw new ResourceNotFoundException("Product", "id", productId);
        }
        if(productDto.getProductId() == null) {
            productDto.setProductId(productId);
        }
        Product product = new Product(productDto, category);
        log.info("Saved Product :{}", productRepository.save(product));
    }
}
