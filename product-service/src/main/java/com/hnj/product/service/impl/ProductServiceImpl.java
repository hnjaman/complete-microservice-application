package com.hnj.product.service.impl;

import com.hnj.product.model.Product;
import com.hnj.product.model.request.ProductRequest;
import com.hnj.product.repository.ProductRepository;
import com.hnj.product.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductServiceImpl implements ProductService {

	private final ProductRepository productRepository;

	@Autowired
	public ProductServiceImpl(ProductRepository productRepository) {
		this.productRepository = productRepository;
	}

	@Override
	public Product addProduct(ProductRequest productRequest) {
		Product product = new Product().builder()
				.productCode(productRequest.getProductCode())
				.productTitle(productRequest.getProductTitle())
				.imageUrl(productRequest.getImageUrl())
				.discountOffer(productRequest.getDiscountOffer())
				.build();

		return productRepository.save(product);
	}

	@Override
	public List<Product> getAllProducts() {
		return productRepository.findAll();
	}

	@Override
	public Optional<Product> getProductById(Integer productId) {
		return productRepository.findById(productId);
	}

	@Override
	public void addProductOffer(Integer productId, Double discountOffer) {
		Optional<Product> product = getProductById(productId);
		if(product.isPresent()){
			product.get().setDiscountOffer(discountOffer);
			productRepository.save(product.get());
		}
	}
}
