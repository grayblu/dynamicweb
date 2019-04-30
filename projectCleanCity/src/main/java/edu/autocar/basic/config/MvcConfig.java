package edu.autocar.basic.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewResolverRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration	// 공통설정
@EnableWebMvc	// SpringMvc 활성화
@ComponentScan(basePackages= {"edu.autocar"})	// 빈 자동 등록
public class MvcConfig implements WebMvcConfigurer{
	public void addResourceHandlers(
						final ResourceHandlerRegistry registry) {
		// css, js, 이미지 등의 정적 파일 배치 위치 등록 - 스프링이 처리 안함
		registry.addResourceHandler("/resources/**") // 적용 경로
				.addResourceLocations("/resources/"); // 웹 경로
	}
	
	@Override
	public void configureViewResolvers(ViewResolverRegistry registry) {
		// JSP 뷰 리졸러 설정
		// 뷰 이름 앞,뒤에 붙일 prefix, surfix 설정
		registry.jsp("/WEB-INF/views/", ".jsp");
	}
}
