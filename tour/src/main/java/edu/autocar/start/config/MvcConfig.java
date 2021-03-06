package edu.autocar.start.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewResolverRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.tiles3.TilesConfigurer;
import org.springframework.web.servlet.view.tiles3.TilesViewResolver;

@Configuration
@EnableWebMvc
@EnableTransactionManagement	// transaction 성공 여부에 따라 commit, rollback을 실행하는 기능
@ComponentScan(basePackages= {"edu.autocar"})
public class MvcConfig implements WebMvcConfigurer {
	@Override
	public void addResourceHandlers(final ResourceHandlerRegistry registry) {
		// css, js, 이미지 등의 정적 파일 배치 위치 등록 - 스프링이 처리 안함
		registry.addResourceHandler("/resources/**") // 적용 경로
				.addResourceLocations("/resources/") // 웹 경로
				.setCachePeriod(0);	// 서버 캐시 해제
	}

	@Override
	public void configureViewResolvers(ViewResolverRegistry registry) {
		TilesViewResolver viewResolver = new TilesViewResolver();
		registry.viewResolver(viewResolver);
		// JSP 뷰 리졸러 설정 , viewResolver로 설정되지 않은 path를 실행하기 위해 viewResolver 뒤에 호출
		// 뷰 이름 앞,뒤에 붙일 prefix, surfix 설정
		registry.jsp("/WEB-INF/views/", ".jsp");

	}
	
	@Bean
	public TilesConfigurer tilesConfigurer() {
		TilesConfigurer tilesConfigurer = new TilesConfigurer();
		tilesConfigurer.setDefinitions(
				new String[] {"/WEB-INF/tiles/tiles-layout.xml"});
		tilesConfigurer.setCheckRefresh(true);
		return tilesConfigurer;
	}
	@Bean
	public CommonsMultipartResolver multipartResolver() {
		CommonsMultipartResolver resolver=new CommonsMultipartResolver();
		resolver.setDefaultEncoding("utf-8");
		return resolver;
	}
}
