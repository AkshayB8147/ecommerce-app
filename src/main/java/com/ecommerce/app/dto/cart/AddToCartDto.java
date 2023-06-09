package com.ecommerce.app.dto.cart;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AddToCartDto {
    private Long cartId;
    private Long productId;
    private Integer quantity;
}
