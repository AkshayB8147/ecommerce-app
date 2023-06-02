package com.ecommerce.app.service;

import com.ecommerce.app.entity.Product;
import com.ecommerce.app.exceptions.ProductNotPresentException;
import com.ecommerce.app.repository.ProductRepository;
import com.ecommerce.app.service.dao.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class ProductServiceImpl implements ProductService {
    @Autowired
    private ProductRepository productRepository;
    @Override
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    @Override
    public List<Product> saveAllProducts(List<Product> products) {
        return productRepository.saveAll(products);
    }

    @Override
    public Product getProductById(Long productId) throws ProductNotPresentException{
        Optional<Product> product = productRepository.findById(productId);
        if (!product.isPresent()){
            throw new ProductNotPresentException("Product not found " + productId);
        }
        return product.get();
    }

    @Override
    public Product saveProduct(Product product) {
        return productRepository.save(product);
    }

    @Override
    public Product updateProduct(Long productId, Product product){
        Product actualProduct = productRepository.findById(productId).get();
        String name = (actualProduct.getName() == product.getName() && Objects.nonNull(product.getName()))
                            ? product.getName()
                            : actualProduct.getName();
        String description = (actualProduct.getDescription() == product.getDescription() && Objects.nonNull(product.getDescription()))
                ? product.getDescription()
                : actualProduct.getDescription();
        Double price = (actualProduct.getPrice() == product.getPrice() && Objects.nonNull(product.getPrice()))
                ? product.getPrice()
                : actualProduct.getPrice();
        String imageUrl = (actualProduct.getImageUrl() == product.getImageUrl() && Objects.nonNull(product.getImageUrl()))
                ? product.getImageUrl()
                : actualProduct.getImageUrl();

        actualProduct.setName(name);
        actualProduct.setDescription(description);
        actualProduct.setPrice(price);
        actualProduct.setImageUrl(imageUrl);
        return productRepository.save(actualProduct);
    }
}
