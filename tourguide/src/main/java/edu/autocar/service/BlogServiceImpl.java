package edu.autocar.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import edu.autocar.dao.BlogDao;
import edu.autocar.domain.Blog;
import edu.autocar.domain.BlogPost;
import edu.autocar.domain.PageInfo;

@Repository
public class BlogServiceImpl implements BlogService {

	final static private int PER_PAGE_COUNT = 6;
	@Autowired
	BlogDao dao;
	@Autowired
	BlogPostService blogPostService;

	@Override
	public PageInfo<Blog> getPage(int page) throws Exception {
		int totalCount = dao.count();
		int start = (page - 1) * PER_PAGE_COUNT;
		int end = start + PER_PAGE_COUNT;

		List<Blog> list = dao.getPage(start + 1, end);
		for (Blog blog : list) {
			List<BlogPost> plist = blogPostService.getBlogPost(blog.getUserId());
			blog.setList(plist);
		}
		return new PageInfo<>(totalCount, (int) Math.ceil(totalCount / (double) PER_PAGE_COUNT), page, PER_PAGE_COUNT,
				list);
	}

	@Override
	public Blog getBlog(String userId) throws Exception {
		
		Blog blog = dao.findById(userId);
		blog.setList(blogPostService.getBlogPost(blog.getUserId()));
		
		return blog;
	}

	@Override
	public void create(Blog blog) throws Exception {
		// TODO Auto-generated method stub

	}

	@Override
	public boolean update(Blog blog) throws Exception {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delete(int blogId) throws Exception {
		// TODO Auto-generated method stub
		return false;
	}

}
