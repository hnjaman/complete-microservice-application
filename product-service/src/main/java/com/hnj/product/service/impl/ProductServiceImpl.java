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
		Double currentPrice = null;
		if (productRequest.getDiscountOffer() != null && productRequest.getDiscountOffer() > 0){
			Double discountPrice = (productRequest.getDiscountOffer()*productRequest.getPrice())/100;
			currentPrice = productRequest.getPrice()-discountPrice;
		}
		Product product = new Product().builder()
				.productCode(productRequest.getProductCode())
				.productTitle(productRequest.getProductTitle())
				.imageUrl(productRequest.getImageUrl())
				.discountOffer(productRequest.getDiscountOffer())
				.price(productRequest.getPrice())
				.currentPrice(currentPrice)
				.build();

		return productRepository.save(product);
	}

	@Override
	public List<Product> getAllProducts() {
		return productRepository.findAllByOrderByPriceAsc();
	}

	@Override
	public Optional<Product> getProductById(Integer productId) {
		return productRepository.findById(productId);
	}

	@Override
	public void addProductOffer(Integer productId, Double discountOffer) {
		Optional<Product> product = getProductById(productId);
		if(product.isPresent() && product.get().getPrice() != null){
			Double discountPrice = (discountOffer*product.get().getPrice())/100;
			product.get().setCurrentPrice(product.get().getPrice()-discountPrice);
			product.get().setDiscountOffer(discountOffer);
			productRepository.save(product.get());
		}
	}

	@Override
	public Product addPrice(Integer id, Double price) {
		if (price <= 0)
			return null;
		Optional<Product> product = productRepository.findById(id);
		if(product.isPresent()){
			if (product.get().getDiscountOffer() != null && product.get().getDiscountOffer() > 0){
				Double discountPrice = (product.get().getDiscountOffer()*price)/100;
				product.get().setPrice(price);
				product.get().setCurrentPrice(price-discountPrice);
			} else {
				product.get().setPrice(price);
			}
			return productRepository.save(product.get());
		} else {
			return null;
		}
	}
}
