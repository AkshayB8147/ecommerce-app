package com.ecommerce.app.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "products")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Product {
    @Id
    @SequenceGenerator(
            name = "productId",
            sequenceName = "products_sequence"
    )
    @GeneratedValue(
            generator = "products_sequence",
            strategy = GenerationType.SEQUENCE
    )
    private Long productId;
    private String name;
    private String description;
    private Double price;
    private String imageUrl;

    @ManyToOne()
    private Category category;

}
