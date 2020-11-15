package com.sungsu.dev.app.product;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.sungsu.dev.Application;
import com.sungsu.dev.app.common.exception.ServiceException;
import com.sungsu.dev.app.product.service.ProductService;

@DisplayName("ProductRestController 테스트")
@ExtendWith(SpringExtension.class)
@SpringBootTest(classes = Application.class)
class ProductRestControllerTest {

	@Autowired
	private ProductService productService;

	@Test
	@DisplayName("상품이 존재하지 않음.")
	public void notFoundProduct() {
		Assertions.assertThrows(ServiceException.class, () -> productService.getProduct(1));
	}



}