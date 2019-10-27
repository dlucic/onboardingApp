package com.davorin.onboarding;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@SpringBootApplication
public class OnboardingApplication extends SpringBootServletInitializer {

	public static void main(String[] args) {
		SpringApplication.run(OnboardingApplication.class, args);
	}

}
