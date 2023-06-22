package com.ecommerce.app.controller;

import com.ecommerce.app.dto.response.ApiResponse;
import com.ecommerce.app.entity.Category;
import com.ecommerce.app.service.dao.CategoryService;
import com.ecommerce.app.utils.Helper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(value = "/category")
public class CategoryController {
    @Autowired
    private CategoryService categoryService;

    @GetMapping(value = "/")
    public ResponseEntity<List<Category>> getCategories() {
        List<Category> categories = categoryService.getAllCategories();
        return new ResponseEntity<>(categories, HttpStatus.OK);
    }

    @PostMapping(value = "/")
    public ResponseEntity<ApiResponse> createCategory(@Valid @RequestBody Category category){
        if(!Helper.isNull(categoryService.readCategory(category.getName()))) {
            return new ResponseEntity<>(new ApiResponse(false, "Category already exists"), HttpStatus.CONFLICT);
        }
        categoryService.saveCategory(category);
        return new ResponseEntity<>(new ApiResponse(true, "Category created successfully"),HttpStatus.CREATED);
    }

    @PutMapping(value = "/{categoryId}/update")
    public ResponseEntity<ApiResponse> updateCategory(
            @PathVariable(name = "categoryId") Long categoryId,
            @Valid @RequestBody Category category
    ){
        if(Helper.isNull(categoryService.readCategory(categoryId))) {
            return new ResponseEntity<>(new ApiResponse(false, "Category not exists"), HttpStatus.CONFLICT);
        }
        categoryService.updateCategory(categoryId, category);
        return new ResponseEntity<>(new ApiResponse(true, "Category updated successfully"),HttpStatus.CREATED);
    }

}