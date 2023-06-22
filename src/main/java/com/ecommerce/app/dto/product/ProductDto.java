package com.ecommerce.app.dto.product;

import com.ecommerce.app.entity.Product;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductDto {
    private Long productId;
    @NotNull
    private String name;
    @NotNull
    private double price;
    @NotNull
    private String description;
    @NotNull
    private String imageUrl;
    @NotNull
    private Long categoryId;

    public ProductDto(Product product) {
        this.productId = product.getProductId();
        this.name = product.getName();
        this.price = product.getPrice();
        this.description = product.getDescription();
        this.imageUrl = product.getImageUrl();
        this.categoryId = product.getCategory().getCategoryId();
    }


}
