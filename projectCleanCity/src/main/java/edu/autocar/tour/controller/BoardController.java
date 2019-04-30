package edu.autocar.tour.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import edu.autocar.domain.Board;
import edu.autocar.domain.PageInfo;
import edu.autocar.tour.service.BoardService;

@Controller
@RequestMapping("/board")
public class BoardController {
	@Autowired
	BoardService service;
	
	@GetMapping("/list")
	public void list(
			@RequestParam(value="page", defaultValue="1") int page,
			Model model) throws Exception{
		PageInfo<Board> pi = service.getPage(page);
		model.addAttribute("pi", pi);
	}
}
