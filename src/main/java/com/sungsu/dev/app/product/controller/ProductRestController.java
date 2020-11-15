package com.sungsu.dev.app.product.controller;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.sungsu.dev.app.common.models.response.ErrorResponse;
import com.sungsu.dev.app.common.models.response.ResponseModel;
import com.sungsu.dev.app.common.models.response.SuccessResponse;
import com.sungsu.dev.app.product.domain.Product;
import com.sungsu.dev.app.product.service.ProductService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@RestController
@RequiredArgsConstructor
@Slf4j
public class ProductRestController {
	private static final int PAGE_SIZE = 20;

	private final ProductService productService;

	/**
	 * 상품 생성
	 * @return
	 */
	@PostMapping(value = "/products", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseModel createProduct(@RequestBody Product productRequest) {
		log.debug("createProduct : {}", productRequest);
		final Product saved = productService.saveProduct(productRequest);
		return SuccessResponse.create(ProductModel.create(saved));
	}

	/**
	 * 상품 조회
	 * @return
	 */
	@GetMapping(value = "/products/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseModel getProduct(@PathVariable long id) {
		final Product product = productService.getProduct(id);
		return SuccessResponse.create(ProductModel.create(product));
	}

	/**
	 * 상품 목록 조회
	 * @return
	 */
	@GetMapping(value = "/products", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseModel getProducts(@RequestParam(defaultValue = "0") int page) {
		final Page<Product> products = productService.getProducts(page, PAGE_SIZE);
		return SuccessResponse.create(new ProductPageModel(products));
	}

	/**
	 * 상품 전체 업데이트(UPSERT)
	 *  - 기존 리소스를 업데이트
	 *  - 멱등성 보장됨.
	 * @return
	 */
	@PutMapping(value = "/products/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseModel putProduct(@RequestBody @Valid UpdateProduct updateProduct) {
		final Product update = updateProduct.toProduct();
		final Product product = productService.saveProduct(update);
		return SuccessResponse.create(ProductModel.create(product));
	}

	/**
	 * 상품 부분 업데이트
	 *  - 기존 리소스 업데이트
	 *  - 멱등성 보장 안됨
	 * @return
	 */
	@PatchMapping(value = "/products/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseModel patchProduct(@RequestBody @Valid PatchProduct patchProduct) {
		final Product origin = productService.getProduct(patchProduct.getId());
		final Product update = productService.saveProduct((patchProduct.toProduct(origin)));
		return SuccessResponse.create(ProductModel.create(update));

	}

	/**
	 * 상품 삭제
	 * @return
	 */
	@DeleteMapping(value = "/products/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseModel deleteProduct(@PathVariable long id) {
		productService.deleteProduct(id);
		return SuccessResponse.EMPTY;
	}

	@ExceptionHandler(MethodArgumentNotValidException.class)
	@ResponseStatus(value= HttpStatus.BAD_REQUEST)
	@ResponseBody
	ResponseModel processValidationError(HttpServletRequest request, MethodArgumentNotValidException ex) throws Exception {
		log.error("[product request error]", ex);
		return new ErrorResponse(HttpStatus.BAD_REQUEST.value(), "parameter is not present");
	}


}
