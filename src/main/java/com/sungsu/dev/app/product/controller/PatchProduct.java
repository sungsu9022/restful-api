package com.sungsu.dev.app.product.controller;

import javax.validation.constraints.Min;

import org.springframework.util.StringUtils;

import com.sungsu.dev.app.product.domain.Product;
import com.sungsu.dev.app.product.domain.Product.ProductBuilder;
import com.sungsu.dev.app.product.domain.model.Category;

import lombok.Getter;

@Getter
class PatchProduct {
	@Min(1)
	private long id;
	private String name;
	private Category category;
	private String description;
	private Long cost;

	Product toProduct(Product origin) {
		final ProductBuilder builder = origin.toBuilder();
		if(!StringUtils.isEmpty(name)) {
			builder.name(name);
		}

		if(category != null) {
			builder.category(category);
		}

		if(!StringUtils.isEmpty(description)) {
			builder.description(description);
		}

		if(cost != null) {
			builder.cost(cost);
		}

		return builder.build();
	}
}
