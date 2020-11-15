package com.sungsu.dev.app.product.controller;

import javax.validation.constraints.Min;

import com.sungsu.dev.app.product.domain.Product;
import com.sungsu.dev.app.product.domain.model.Category;

import lombok.Getter;

@Getter
class UpdateProduct {
	@Min(1)
	private long id;
	private String name;
	private Category category;
	private String description;
	private long cost;

	Product toProduct() {
		return Product.builder()
			.id(id)
			.name(name)
			.category(category)
			.description(description)
			.cost(cost)
			.build();
	}
}
