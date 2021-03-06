package edu.autocar.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import edu.autocar.domain.Blog;
import edu.autocar.domain.BlogPost;
import edu.autocar.domain.PageInfo;
import edu.autocar.service.BlogPostService;
import edu.autocar.service.BlogService;

@Controller
@RequestMapping("/blogs")
public class BlogController {

	@Autowired
	BlogService service;
	
	@Autowired
	BlogPostService postService;
	


	@GetMapping("/list")
	public void list(Model model, @RequestParam(value = "page", defaultValue = "1") int page) throws Exception {
		
		PageInfo<Blog> pi = service.getPage(page);
		model.addAttribute("pi", pi);
	}

	@GetMapping("/{userId}/list")
	public String getBlog(@PathVariable String userId, Model model) throws Exception {
		Blog blog = service.getBlog(userId);

//		if (blog.getList().size() == 0)	return "redirect:../list";

		model.addAttribute("blog", blog);
		return "blogs/user/list";
	}
	
	@GetMapping("/{userId}/view/{postId}")
	public String getPost(@PathVariable int postId, Model model) throws Exception {
		BlogPost post = postService.getPost(postId);
		int readCnt = post.getReadCnt();
		readCnt ++ ;
		post.setReadCnt(readCnt);
		model.addAttribute("post", post);
		return "blogs/user/view";
	}

	@GetMapping("/create")
	public void getCreate(Blog blog) throws Exception {
		
	}
	
	@GetMapping("/{userId}/write")
	public String getWrite(Model model,BlogPost post) throws Exception {
		model.addAttribute("post", post );
		return "blogs/user/write";
	}
	
	@PostMapping("/{userId}/write")
	public String postWrite(@Valid BlogPost post,BindingResult result) throws Exception{
		if (result.hasErrors()) {
			return "blogs/user/write";
		}
		postService.create(post);
		return "redirect:list";
	}

	@PostMapping("/create")
	public String postCreate(@Valid Blog blog, BindingResult result) throws Exception {
		if (result.hasErrors()) {
			return "blog/create";
		}
		service.create(blog);
		return "redirect:list";
	}
	
	@GetMapping("/{userId}/edit/{postId}")
	public String getEdit(@PathVariable int postId, Model model) throws Exception{
		BlogPost blogPost = postService.getPost(postId);
		model.addAttribute("edit", blogPost);

		return "blogs/user/edit";
	}
	
	@PostMapping("/{userId}/edit/{postId}")
	public String postEdit(@Valid BlogPost post, BindingResult result) throws Exception {
		if (result.hasErrors())
			return "blogs/user/edit";
		
		if(postService.update(post)){
			return "blogs/user/view";
		}
		return "blogs/user/edit";
			
	}
	
	
	
}
