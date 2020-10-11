package com.sungsu.dev.app.product;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ProductService {

	private final ProductRepository productRepository;

	public Product saveProduct(Product product) {
		Product saved = productRepository.save(product);
		return saved;
	}
}
