package com.hnj.product.model.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductRequest {
    private String productCode;
    private String productTitle;
    private String imageUrl;
    private Double discountOffer;
    private Double price;
}
