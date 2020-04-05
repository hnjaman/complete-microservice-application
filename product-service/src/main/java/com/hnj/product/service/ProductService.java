package com.hnj.product.service;

import com.hnj.product.model.Product;
import com.hnj.product.model.request.ProductRequest;

import java.util.List;
import java.util.Optional;

public interface ProductService {
    Product addProduct(ProductRequest productRequest);
    List<Product> getAllProducts();
    Optional<Product> getProductById(Integer productId);
    void addProductOffer(Integer productId, Double discountOffer);
    Product addPrice(Integer id, Double price);
}
