package com.sungsu.dev.app.common.models.response;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class SuccessResponse<T> implements ResponseModel {
	private boolean success = Boolean.TRUE;
	private T result;

	public static <T> SuccessResponse create(T result) {
		final SuccessResponse<T> ins = new SuccessResponse<>();
		ins.result = result;
		return ins;
	}

	public static final SuccessResponse EMPTY = new SuccessResponse();

}
