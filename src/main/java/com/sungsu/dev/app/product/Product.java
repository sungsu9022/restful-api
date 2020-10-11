package com.sungsu.dev.app.product;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import com.sungsu.dev.app.product.category.Category;

import lombok.Getter;
import lombok.ToString;

/**
 * 상품
 */
@Entity
@Table(name = "product")
@Getter
@ToString
public class Product {
	@Id
	@GeneratedValue
	private long id;

	@Column(name = "name")
	private String name;

	@Enumerated(EnumType.STRING)
	@Column(name = "category")
	private Category category;

	@Column(name = "description")
	private String description;

	@Column(name = "cost")
	private long cost; // 원가
}
