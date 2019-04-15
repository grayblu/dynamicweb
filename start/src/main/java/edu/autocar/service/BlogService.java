package edu.autocar.service;

import edu.autocar.domain.Blog;
import edu.autocar.domain.PageInfo;

public interface BlogService {

	PageInfo<Blog> getPage(int page) throws Exception;

	Blog getBlog(String userId) throws Exception;

	void create(Blog blog) throws Exception;

	boolean update(Blog blog) throws Exception;

	boolean delete(int blogId) throws Exception;

}
