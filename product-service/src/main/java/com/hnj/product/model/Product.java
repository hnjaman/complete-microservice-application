package com.hnj.product.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "product")
public class Product {
    @Id
    @GeneratedValue
    private Integer id;

    @Column(name = "product_code")
    @NotNull
    private String productCode;

    @Column(name = "product_title")
    @NotNull
    private String productTitle;

    @Column(name = "image_url")
    private String imageUrl;

    @Column(name = "discount_offer")
    private Double discountOffer;

    @Column(name = "price")
    private Double price;

    @Column(name = "current_price")
    private Double currentPrice;
}
