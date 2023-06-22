package com.ecommerce.app.controller;

import com.ecommerce.app.dto.response.ApiResponse;
import com.ecommerce.app.entity.Cart;
import com.ecommerce.app.entity.Product;
import com.ecommerce.app.entity.User;
import com.ecommerce.app.service.dao.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/cart/")
public class CartController {
    @Autowired
    private CartService cartService;

    @GetMapping(value = "/")
    public ResponseEntity<List<Cart>> getCartItems(){
        List<Cart> carts = cartService.getCartItems();
        return new ResponseEntity<>(carts, HttpStatus.CREATED);
    }

    public ResponseEntity<ApiResponse> addToCart(Product product, User user){

        return new ResponseEntity<>(new ApiResponse(true,"Product added to cart"), HttpStatus.OK);
    }
}
