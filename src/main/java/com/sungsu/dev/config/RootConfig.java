package com.sungsu.dev.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

/**
 * Created by seongsuPark on 2018. 9. 8..
 */
@Configuration
@ComponentScan(basePackages = "com.sungsu.dev")
@EnableAspectJAutoProxy
public class RootConfig {
}
