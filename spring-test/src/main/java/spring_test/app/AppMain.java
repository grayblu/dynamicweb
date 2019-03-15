package spring_test.app;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.GenericApplicationContext;
import org.springframework.stereotype.Component;

import spring_test.config.AppConfig;
import spring_test.domain.Article;
import spring_test.service.ArticleService;
@Component
public class AppMain {
	@Autowired
	ArticleService service;
	
	public AppMain() {
	}
	public AppMain(ArticleService service) {
		this.service = service;
	}
	public void setArticleService(ArticleService service) {
		this.service = service;
	}
	
	public void run() {
		Article article = new Article("테스트", "테스트 내용");
		service.insert(article);
		
		Article article2 = service.selectOne(100);
		System.out.println(article2);
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		GenericApplicationContext ctx = new AnnotationConfigApplicationContext(AppConfig.class);
		AppMain app = ctx.getBean(AppMain.class);
		app.run();
		
		ctx.close();
	}

}
