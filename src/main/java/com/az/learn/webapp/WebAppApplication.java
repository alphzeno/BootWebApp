package com.az.learn.webapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;

@SpringBootApplication
public class WebAppApplication extends SpringBootServletInitializer {

	private static Class<WebAppApplication> applicationClass = WebAppApplication.class;

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder applicationBuilder) {
		return applicationBuilder.sources(applicationClass);
	}

	public static void main(String[] args) {
		SpringApplication.run(applicationClass, args);
	}
}
