package com.ecommerce.app.controller;

import com.ecommerce.app.dto.product.ProductDto;
import com.ecommerce.app.dto.response.ApiResponse;
import com.ecommerce.app.entity.Category;
import com.ecommerce.app.service.dao.CategoryService;
import com.ecommerce.app.service.dao.ProductService;
import com.ecommerce.app.utils.Helper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(value = "/product")
public class ProductController {
    @Autowired
    private ProductService productService;
    @Autowired
    private CategoryService categoryService;

    @GetMapping(value = "/")
    public ResponseEntity<List<ProductDto>> getAllProducts(){
        List<ProductDto> products = productService.getAllProducts();
        return new ResponseEntity<>(products,HttpStatus.OK);
    }

    @GetMapping(value = "/{productId}")
    public ResponseEntity<ProductDto> getProductById(@PathVariable(name = "productId") Long productId){
        ProductDto productDto = productService.getProductById(productId);
        return new ResponseEntity<>(productDto, HttpStatus.OK);
    }

    @PostMapping(value = "/")
    public ResponseEntity<ApiResponse> addProduct(@Valid @RequestBody ProductDto productDtoRequest){
        Category category = categoryService.readCategory(productDtoRequest.getCategoryId());
        if(Helper.isNull(category)) {
            return new ResponseEntity<>(new ApiResponse(false, "Category does not exists"), HttpStatus.CONFLICT);
        }
        productService.saveProduct(productDtoRequest, category);
        return new ResponseEntity<>(new ApiResponse(true, "Product added successfully"), HttpStatus.CREATED);
    }

    @PutMapping(value = "/{productId}/update")
    public ResponseEntity<ApiResponse> updateProduct(
            @PathVariable(name = "productId")Long productId,
            @Valid @RequestBody ProductDto productDtoRequest
    ) {
        Category category = categoryService.readCategory(productDtoRequest.getCategoryId());
        if(Helper.isNull(category)) {
            return new ResponseEntity<>(new ApiResponse(false, "Category does not exists"),HttpStatus.CONFLICT);
        }
        productService.updateProduct(productId, productDtoRequest, category);
        return new ResponseEntity<>(new ApiResponse(true, "Product updated successfully"),HttpStatus.OK);
    }
}

