package edu.autocar.dao;

import java.util.List;

import edu.autocar.domain.BlogPost;

public interface BlogPostDao extends CrudDao<BlogPost,Integer> {

	List<BlogPost> getBlogPost(String userId) throws Exception;
	
	
	
	
}
