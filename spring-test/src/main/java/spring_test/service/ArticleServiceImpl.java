package spring_test.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import spring_test.dao.ArticleDao;
import spring_test.domain.Article;
@Service
public class ArticleServiceImpl implements ArticleService {
	@Autowired
	ArticleDao dao;
//	동일 타입의 이름이 여러 개인 경우, @Resource
	public ArticleServiceImpl() {
	}

	public ArticleServiceImpl(ArticleDao dao) {
		this.dao = dao;
	}

	public void setDao(ArticleDao dao) {
		this.dao = dao;
	}

	@Override
	public void insert(Article article) {
		System.out.println("> Article Service : 글 저장");
		dao.insert(article);
	}


	@Override
	public Article selectOne(int id) {
		System.out.println("> Article Service : 글 추출");
		return dao.selectOne(id);
	}
}
