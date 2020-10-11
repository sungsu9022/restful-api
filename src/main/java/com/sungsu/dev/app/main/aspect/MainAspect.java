package com.sungsu.dev.app.main.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import com.sungsu.dev.config.env.EnvConfig;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Aspect
@Component
@Slf4j
 @RequiredArgsConstructor
public class MainAspect {
	public final static String DUMMY_VALUE = "returnDummy";
	private final EnvConfig envConfig;

	public Object returnDummy(ProceedingJoinPoint joinPoint) throws Throwable {
		if (!isLocalEnvironment()) {
			return joinPoint.proceed();
		}

		// local 환경인 경우 본  메소드를 수행하지 않고 dummy value를 return
		log.info(DUMMY_VALUE);
		return DUMMY_VALUE;
	}

	/**
	 * 로컬 환경인지 확ㅇ니
	 * @return
	 */
	private boolean isLocalEnvironment() {
		return envConfig.isLocal();
	}
}
