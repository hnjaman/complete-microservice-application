package com.hnj.offer.model;

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
@Entity(name = "offer")
public class Offer {
    @Id
    @GeneratedValue
    private Integer id;

    @Column(name = "product_id")
    @NotNull
    private Integer productId;

    @Column(name = "discount_offer")
    private Double discountOffer;
}
