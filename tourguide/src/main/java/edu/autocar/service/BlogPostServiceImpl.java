package edu.autocar.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import edu.autocar.dao.BlogPostDao;
import edu.autocar.domain.BlogPost;

@Repository
public class BlogPostServiceImpl implements BlogPostService {

	@Autowired
	BlogPostDao dao;
	
	@Override
	public List<BlogPost> getBlogPost(String userId) throws Exception {	
		return dao.getBlogPost(userId);
	}
	
	@Override
	public BlogPost getPost(int postId) throws Exception {
		// TODO Auto-generated method stub
		return dao.findById(postId);
	}
	
	@Override
	public void create(BlogPost post) throws Exception {
		// TODO Auto-generated method stub
		dao.insert(post);
		
	}
	
	
	
	
	
	@Override
	public boolean update(BlogPost post) throws Exception {
		// TODO Auto-generated method stub
		if(dao.update(post)==0)
			return false;
		return true;
	}
	
	
}
