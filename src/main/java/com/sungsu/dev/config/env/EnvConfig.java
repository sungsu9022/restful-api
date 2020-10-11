package com.sungsu.dev.config.env;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import lombok.Getter;

@Configuration
@ConfigurationProperties(prefix = "spring.profiles")
@Getter
public class EnvConfig {
	private String active;

	public boolean isLocal() {
		return Phase.from(active) == Phase.LOCAL;
	}

	public void setActive(String active) {
		this.active = active;
	}
}
