package com.ecommerce.app.service.dao;

import com.ecommerce.app.dto.cart.AddToCartDto;
import com.ecommerce.app.dto.cart.CartDto;
import com.ecommerce.app.entity.Cart;
import com.ecommerce.app.entity.Product;
import com.ecommerce.app.entity.User;

import java.util.List;

public interface CartService {

    CartDto getCart(User user);

    void addToCart(AddToCartDto addToCartDto, Product product, User user);

}