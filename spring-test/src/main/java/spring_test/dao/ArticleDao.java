package spring_test.dao;

import spring_test.domain.Article;

public interface ArticleDao {
	void insert(Article article);
	Article selectOne(int id);
}
