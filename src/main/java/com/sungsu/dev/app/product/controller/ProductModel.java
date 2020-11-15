package com.sungsu.dev.app.product.controller;

import com.sungsu.dev.app.product.domain.Product;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Getter
class ProductModel {
	private Product product;

	static ProductModel create(Product product) {
		return new ProductModel(product);
	}
}
