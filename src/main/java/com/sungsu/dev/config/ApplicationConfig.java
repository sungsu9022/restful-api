package com.sungsu.dev.config;

import java.time.LocalDateTime;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.json.Jackson2ObjectMapperBuilder;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.databind.module.SimpleModule;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.sungsu.dev.app.common.serializer.LocalDateTimeDeserializer;
import com.sungsu.dev.app.common.serializer.LocalDateTimeSerializer;

@Configuration
public class ApplicationConfig {

	@Bean
	public ObjectMapper objectMapper() {
		final ObjectMapper objectMapper = Jackson2ObjectMapperBuilder.json()
			.featuresToDisable(SerializationFeature.FAIL_ON_EMPTY_BEANS)
			.featuresToDisable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS)
			.build();

		objectMapper.registerModule(new JavaTimeModule());
		objectMapper.registerModule(localDateTimeModule());
		return objectMapper;
	}

	@Bean(name = "localDateTimeModule")
	public SimpleModule localDateTimeModule() {
		final SimpleModule module = new SimpleModule();
		module.addSerializer(LocalDateTime.class, new LocalDateTimeSerializer());
		module.addDeserializer(LocalDateTime.class, new LocalDateTimeDeserializer());
		return module;
	}

}
