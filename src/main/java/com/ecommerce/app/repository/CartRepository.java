package com.ecommerce.app.repository;

import com.ecommerce.app.entity.Cart;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CartRepository extends JpaRepository<Cart, Long> {
    public Cart getCartByUser(Long userId);
}
