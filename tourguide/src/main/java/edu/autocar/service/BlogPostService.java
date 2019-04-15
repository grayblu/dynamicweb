package edu.autocar.service;

import java.util.List;

import edu.autocar.domain.BlogPost;

public interface BlogPostService {

	List<BlogPost> getBlogPost(String userId) throws Exception;
	
	BlogPost getPost(int postId) throws Exception;
	
	void create(BlogPost post) throws Exception;
	
	boolean update(BlogPost edit) throws Exception;
}
