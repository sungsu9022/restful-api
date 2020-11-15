package com.sungsu.dev.app.common.handler;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.sungsu.dev.app.common.exception.ServiceException;
import com.sungsu.dev.app.common.exception.ServiceException.ErrorCode;
import com.sungsu.dev.app.common.models.response.ErrorResponse;
import com.sungsu.dev.app.common.models.response.ResponseModel;

import lombok.extern.slf4j.Slf4j;

@ControllerAdvice
@Slf4j
public class GlobalExceptionHandler {
	private static final int UNKNOWN_ERROR_CODE = 9999;

	@ExceptionHandler(ServiceException.class)
	public ResponseEntity<ResponseModel> handleSprinklingMoneyException(ServiceException e, HttpServletRequest request) {
		final ErrorCode errorCode = e.getErrorCode();
		log.error("[ServiceException] : {}", e);
		return new ResponseEntity<>(new ErrorResponse(errorCode.getCode(), e.getMessage()), errorCode.getHttpStatus());
	}

	/**
	 * 처리되지 않은 예외를 핸들링
	 * @param e
	 * @param request
	 * @return
	 */
	@ExceptionHandler(Exception.class)
	@ResponseStatus(value = HttpStatus.BAD_REQUEST)
	@ResponseBody
	public ErrorResponse handleException(Exception e, HttpServletRequest request) {
		log.error("Unknown Error : {}", e);
		return new ErrorResponse(UNKNOWN_ERROR_CODE, "Unknown Error");
	}
}
