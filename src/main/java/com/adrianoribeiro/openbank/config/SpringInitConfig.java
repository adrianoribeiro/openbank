package com.adrianoribeiro.openbank.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

@Configuration
public class SpringInitConfig extends AbstractAnnotationConfigDispatcherServletInitializer {

	@Override
	protected Class<?>[] getRootConfigClasses() {

		return new Class<?>[] { RootConfig.class } ;
	}

	@Override
	protected Class<?>[] getServletConfigClasses() {

		return new Class<?>[] { CustomWebSecurityConfigurerAdapter.class };
	}

	@Override
	protected String[] getServletMappings() {

		return new String[] {"/"};
	}

}
