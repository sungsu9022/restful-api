package com.sungsu.dev.app.product.domain.model;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
@Getter
public enum Category {
	TOP,
	BOTTOM,
	OUTER
}
