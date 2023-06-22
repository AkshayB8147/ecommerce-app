package com.ecommerce.app.entity;

import com.ecommerce.app.dto.product.ProductDto;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Entity
@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long productId;

    @NotBlank
    private String name;

    @NotNull
    private double price;

    @NotBlank
    @Column(columnDefinition = "LONGTEXT")
    private String description;

    @NotBlank
    private String imageUrl;

    // Many products to one category bidirectional relationship
    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "category_id", nullable = false)
    private Category category;

    public Product(ProductDto productDto, Category category) {
        super();
        this.productId = productDto.getProductId();
        this.name = productDto.getName();
        this.price = productDto.getPrice();
        this.description = productDto.getDescription();
        this.imageUrl = productDto.getImageUrl();
        this.category = category;
    }


}