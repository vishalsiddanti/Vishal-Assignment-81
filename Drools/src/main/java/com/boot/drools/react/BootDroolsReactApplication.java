package com.boot.drools.react;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class BootDroolsReactApplication {
	
	private static ApplicationContext appContext;

	public static void main(String[] args) {
		appContext = SpringApplication.run(BootDroolsReactApplication.class, args);
		
		System.out.println("droolsConfig Object : "+appContext.containsBean("droolsConfig"));
	}
}