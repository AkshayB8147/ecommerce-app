package com.ecommerce.app.dto.cart;

import com.ecommerce.app.entity.Product;
import lombok.AllArgsConstructor;
import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
@AllArgsConstructor
public class CartItemDto {
    private Long cartId;
    @NotNull
    private Integer quantity;
    @NotNull
    private Product product;
}
