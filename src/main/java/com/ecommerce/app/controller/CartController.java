package com.ecommerce.app.controller;

import com.ecommerce.app.dto.cart.AddToCartDto;
import com.ecommerce.app.dto.cart.CartDto;
import com.ecommerce.app.dto.response.ApiResponse;
import com.ecommerce.app.entity.Cart;
import com.ecommerce.app.entity.Product;
import com.ecommerce.app.entity.User;
import com.ecommerce.app.service.AuthenticationService;
import com.ecommerce.app.service.dao.CartService;
import com.ecommerce.app.service.dao.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/cart")
public class CartController {
    @Autowired
    private CartService cartService;
    @Autowired
    private ProductService productService;
    @Autowired
    private AuthenticationService authService;

    @GetMapping(value = "/")
    public ResponseEntity<CartDto> getAllCartItems(@RequestParam(name = "token") String token) {
        User user = getUserFromToken(token);
        return new ResponseEntity<>(cartService.getCart(user), HttpStatus.OK);
    }

    @PostMapping(value = "/addToCart")
    public ResponseEntity<ApiResponse> addToCart(
            @RequestParam(name = "token") String token,
            @RequestBody AddToCartDto addToCartDto
    ){

        User user = getUserFromToken(token);
        Product product = productService.getProductById(addToCartDto.getProductId());
        cartService.addToCart(addToCartDto, product, user);
        return new ResponseEntity<>(new ApiResponse(true, "product added succesfully"), HttpStatus.OK);
    }

    private User getUserFromToken(String token) {
        authService.authenticate(token);
        return authService.findUserByToken(token);
    }

}
