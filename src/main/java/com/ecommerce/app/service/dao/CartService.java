package com.ecommerce.app.service.dao;

import com.ecommerce.app.entity.Cart;

import java.util.List;

public interface CartService {

    Cart getCartByUser(Long userId);

    List<Cart> getCartItems();
}
