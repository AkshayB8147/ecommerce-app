package com.ecommerce.app.service.mappers;

import com.ecommerce.app.dto.cart.CartItemDto;
import com.ecommerce.app.entity.Cart;
import org.springframework.stereotype.Service;

import java.util.function.Function;

@Service
public class CartItemDtoMapper implements Function<Cart, CartItemDto> {

    @Override
    public CartItemDto apply(Cart cart) {
        return new CartItemDto(
                cart.getCartId(),
                cart.getQuantity(),
                cart.getProduct()
        );
    }

}
