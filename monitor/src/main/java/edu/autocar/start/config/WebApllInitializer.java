package edu.autocar.start.config;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

import edu.autocar.webSocketConfig.WebSocketConfig;

public class WebApllInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {

	@Override
	protected Class<?>[] getRootConfigClasses() {
		return new Class<?>[] { RootConfig.class };
	}

	@Override
	protected Class<?>[] getServletConfigClasses() {
		return new Class<?>[] { 
			MvcConfig.class,
			WebSocketConfig.class
		};
	}

	@Override
	protected String[] getServletMappings() {
		return new String[] { "/" };
	}
	
}
