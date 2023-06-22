package com.ecommerce.app.controller;

import com.ecommerce.app.entity.Product;
import com.ecommerce.app.service.dao.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/products")
public class ProductController {
    @Autowired
    private ProductService productService;

    @GetMapping(value = "/")
    public ResponseEntity<List<Product>> getAllProducts(){
        List<Product> products = productService.getAllProducts();

        return new ResponseEntity<>(products, HttpStatus.OK);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Product> getProductById(@PathVariable(value = "id") Long productId){
        Product product = productService.getProductById(productId);
        return new ResponseEntity<>(product, HttpStatus.OK);
    }

    @PostMapping(value = "/")
    public ResponseEntity<List<Product>> saveAllProducts(@RequestBody List<Product> products){
        List<Product> savedProducts = productService.saveAllProducts(products);
        return new ResponseEntity<>(savedProducts,HttpStatus.CREATED);
    }

    @PostMapping(value = "/saveProduct")
    public ResponseEntity<Product> saveProduct(@RequestBody Product product){
        Product savedProduct = productService.saveProduct(product);
        return new ResponseEntity<>(savedProduct, HttpStatus.CREATED);
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<Product> updateProduct(@PathVariable(value = "id") Long productId, @RequestBody Product product){
        Product savedProduct = productService.updateProduct(productId, product);

        return new ResponseEntity<>(savedProduct, HttpStatus.OK);
    }

}
