package de.check24.projectx.restservicey;

import java.util.Arrays;

import org.apache.log4j.Logger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * @author Tomas Skalicky
 *         <p>
 *         Created on 20.05.2014
 *         </p>
 *         <p>
 *         Copyright (c) 2014, Check24 Vergleichsportal GmbH
 */
@Configuration
@EnableAutoConfiguration
@ComponentScan
public class Application {

	private static final int LOAD_ON_STARTUP_HIGHEST_PRIORITY = 0;

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(new Class[] { Application.class }, args);
		printOutProvidedBeans(context);
	}

	private static void printOutProvidedBeans(ApplicationContext context) {
		
		final Logger logger = Logger.getLogger(Application.class);

		logger.info("Let's inspect the beans provided by Spring Boot:");

		String[] beanNames = context.getBeanDefinitionNames();
		Arrays.sort(beanNames);
		for (String beanName : beanNames) {
			logger.info(beanName);
		}
	}

	// @Bean
	// public ServletRegistrationBean jerseyServlet() {
	// ServletRegistrationBean registration = new ServletRegistrationBean(new ServletContainer(), "/*");
	// registration.setName("jerseyServlet");
	// registration.setLoadOnStartup(LOAD_ON_STARTUP_HIGHEST_PRIORITY);
	//
	// // our rest resources will be available in the path /*
	// registration
	// .addInitParameter(ServletProperties.JAXRS_APPLICATION_CLASS, JerseyConfig.class.getName());
	// return registration;
	// }
}
