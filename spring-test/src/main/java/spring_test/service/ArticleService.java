package spring_test.service;

import spring_test.domain.Article;

public interface ArticleService {
	void insert(Article article);
	Article selectOne(int id);
	
}
