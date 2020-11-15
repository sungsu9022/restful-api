package com.sungsu.dev.app.common.models.response;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;


@NoArgsConstructor(access = AccessLevel.PRIVATE)
@AllArgsConstructor
@Getter
public class ErrorResponse implements ResponseModel {
	public static final ErrorResponse EMPTY_ERROR_RESPONSE = new ErrorResponse();

	private int code;
	private String message;
}
