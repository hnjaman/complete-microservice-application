package com.hnj.product.event;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

@RequiredArgsConstructor
@Getter
@ToString
@EqualsAndHashCode
public class ProductOfferEvent {
    private Integer productId;
    private Double discountOffer;
}
