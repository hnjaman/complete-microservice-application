package com.hnj.offer.model.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class OfferRequest {
    private Integer productId;
    private Double discountOffer;
}
