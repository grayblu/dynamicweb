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
		
		model.addAttribute("post", post);
		return "blogs/user/view";
	}

	@GetMapping("/create")
	public void getCreate(Blog blog) throws Exception {
	}
	
	@GetMapping("/{userId}/write")
	public void getWrite(BlogPost post) throws Exception {
		
	}
	@PostMapping("/{userId}/write")
	public String postWrite(@Valid BlogPost post,BindingResult result) throws Exception{
		System.out.print("1");
		if (result.hasErrors()) {
			System.out.print("2");
			return "blogs/user/write";
		}
		System.out.print("3");
		postService.create(post);
		System.out.print("4");
		return "redirect:blogs/user/list";
	}

	@PostMapping("/create")
	public String postCreate(@Valid Blog blog, BindingResult result) throws Exception {
		if (result.hasErrors()) {
			return "blog/create";
		}
		service.create(blog);
		return "redirect:list";
	}
}
