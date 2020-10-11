package com.sungsu.dev.app.common.models.response;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class ErrorResponse implements ResponseModel {
	private final String code;
	private final String message;
}
