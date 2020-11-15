package com.sungsu.dev.app.common.exception;

import org.springframework.http.HttpStatus;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;

public class ServiceException extends RuntimeException {
	private ErrorCode errorCode;

	public ServiceException(ErrorCode errorCode) {
		super();
		this.errorCode = errorCode;
	}

	public ServiceException(ErrorCode errorCode, String message) {
		super(message);
		this.errorCode = errorCode;
	}
	
	@AllArgsConstructor(access = AccessLevel.PRIVATE)
	public enum ErrorCode {
		NOT_FOUND(HttpStatus.NOT_FOUND);

		private HttpStatus httpStatus;
	}


}
