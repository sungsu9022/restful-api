package com.sungsu.dev.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.json.Jackson2ObjectMapperBuilder;

import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

@Configuration
public class ApplicationConfig {

	@Bean
	public ObjectMapper objectMapper() {
		final ObjectMapper objectMapper = Jackson2ObjectMapperBuilder.json()
			.featuresToDisable(SerializationFeature.FAIL_ON_EMPTY_BEANS)
			.featuresToDisable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS)
			.modules(new JavaTimeModule())
			.build();

		objectMapper.setSerializationInclusion(Include.NON_NULL);
		return objectMapper;
	}

}
