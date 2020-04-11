package com.adrianoribeiro.openbank.config;

import java.util.Collections;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@ComponentScan("com.adrianoribeiro.openbank")
@EnableWebMvc
@EnableSwagger2
public class RootConfig {

	@Bean
	public Docket api() {
		return new Docket(DocumentationType.SWAGGER_2)
				.select()
				.apis(RequestHandlerSelectors.any())
				.paths(PathSelectors.any())
				.build()
				.apiInfo(myApiInfo());
	}

	private ApiInfo myApiInfo() {
	    return new ApiInfo(
	    	      "My REST API - OpenBank", 
	    	      "This application provide a RESTful API that retrieve transactions from OpenBank sandbox and transforms the data." + 
	    	      "v1.0.0", 
	    	      "adrianomsg@gmail.com", 
	    	      "", 
	    	      new Contact("Adriano Ribeiro", "https://github.com/adrianoribeiro/", "adrianomsg@gmail.com"), 
	    	      "License of API", "API license URL", Collections.emptyList());
	}
}
