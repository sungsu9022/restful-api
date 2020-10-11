package com.sungsu.dev.app.product;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.sungsu.dev.app.common.models.response.ResponseModel;
import com.sungsu.dev.app.common.models.response.SuccessResponse;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@RestController
@RequiredArgsConstructor
@Slf4j
public class ProductRestController {

	private final ProductService productService;

	/**
	 * 새 상품 생성
	 * @return
	 */
	@PostMapping(value = "/products", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseModel createProduct(@RequestBody Product productRequest) {
		log.debug("createProduct : {}", productRequest);
		Product saved = productService.saveProduct(productRequest);
		return new SuccessResponse<>(saved);
	}




}
