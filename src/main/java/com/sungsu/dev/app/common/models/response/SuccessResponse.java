package com.sungsu.dev.app.common.models.response;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@AllArgsConstructor
public class SuccessResponse<T> implements ResponseModel {
	private T result;

	public static final SuccessResponse EMPTY = new SuccessResponse();

}
