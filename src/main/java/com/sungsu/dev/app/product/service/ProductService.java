package com.sungsu.dev.app.product.service;

import javax.transaction.Transactional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.sungsu.dev.app.common.exception.ServiceException;
import com.sungsu.dev.app.common.exception.ServiceException.ErrorCode;
import com.sungsu.dev.app.product.domain.Product;
import com.sungsu.dev.app.product.repository.ProductRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ProductService {

	private final ProductRepository productRepository;

	@Transactional
	public Product saveProduct(Product product) {
		final Product saved = productRepository.save(product);
		return saved;
	}

	@Transactional
	public void deleteProduct(long productId) {
		productRepository.deleteById(productId);
	}

	public Product getProduct(long id) {
		return productRepository.findById(id)
			.orElseThrow(() -> new ServiceException(ErrorCode.NOT_FOUND));
	}

	public Page<Product> getProducts(int page, int size) {
		final PageRequest pageRequest = PageRequest.of(page, size);
		return productRepository.findAll(pageRequest);
	}
}
