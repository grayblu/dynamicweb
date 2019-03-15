package spring_test.dao;

import org.springframework.stereotype.Repository;

import spring_test.domain.Article;
@Repository
public class ArticleDaoImpl implements ArticleDao {
	@Override
	public void insert(Article article) {
		// TODO Auto-generated method stub
		System.out.println("==== 글 저장 =========");
		System.out.println("제목 : " + article.getTitle());
		System.out.println("내용 : " + article.getContent());
	}
	@Override
	public Article selectOne(int id) {
		// TODO Auto-generated method stub
		System.out.println("글 id " + id + " 추출");
		return new Article("테스트" + id, "테스트 내용");
	}
	
}
