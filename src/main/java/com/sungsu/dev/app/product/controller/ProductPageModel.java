package com.sungsu.dev.app.product.controller;

import org.springframework.data.domain.Page;

import com.sungsu.dev.app.product.domain.Product;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor(access = AccessLevel.PACKAGE)
@Getter
class ProductPageModel {
	Page<Product> products;
}
