package com.ecommerce.app.service.dao;

import com.ecommerce.app.entity.Cart;

import java.util.List;

public interface CartService {

    public Cart getCartByUser(Long userId);

    public List<Cart> getCartItems();
}
