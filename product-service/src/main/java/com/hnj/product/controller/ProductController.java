package com.hnj.product.controller;

import com.hnj.product.model.Product;
import com.hnj.product.model.request.ProductRequest;
import com.hnj.product.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@CrossOrigin(origins="http://localhost:3000", allowedHeaders="*")
public class ProductController {
	private ProductService productService;

	@Autowired
	public ProductController(ProductService productService){
		this.productService=productService;
	}

	@PostMapping("/products")
	public Product addProduct(@Valid @RequestBody ProductRequest productRequest){
		return productService.addProduct(productRequest);
	}

	@PutMapping("/products/addPrice")
	public Product addPrice(@RequestParam Integer id, @RequestParam Double price){
		return productService.addPrice(id, price);
	}

	@GetMapping("/products")
    public List<Product> getAllProducts(){
	    return productService.getAllProducts();
    }
}
