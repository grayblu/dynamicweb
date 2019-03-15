package edu.autocar.controller;

import java.util.HashMap;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import edu.autocar.domain.Board;
import edu.autocar.domain.PageInfo;
import edu.autocar.service.BoardService;
import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
@RequestMapping("/board")
public class BoardController {
	@Autowired
	BoardService service;
	
	@GetMapping("/list")
	public void list(Model model,
			@RequestParam(value="page", defaultValue="1")int page) throws Exception{
//	리턴타입이 없는 경우 url이 뷰 이름이 됨	board/list
		PageInfo<Board> pi = service.getPage(page);
		log.info(pi.toString());
		model.addAttribute("pi", pi);
	}
	
	@GetMapping("/create")
	public void getCreate(Board board) throws Exception{
		
	}
//	게시판 작성과 관련하여 각 입력 속성의 유효성을 확인하기 위해 @Valid와 BindingResult 인터페이스를 매개변수로 지정 
	@PostMapping("/create")
	public String postCreate(@Valid Board board, BindingResult result) throws Exception{
		log.info(board.toString());
		
		if(result.hasErrors()) {
			log.info("유효성 검증 실패");
			return "board/create";
		}
		
		service.create(board);
		return "redirect:list";
	}
	
	@GetMapping("/view/{boardId}")
	public String view(@PathVariable int boardId, Model model) throws Exception{
			Board board = service.getBoard(boardId);
			model.addAttribute("board", board);
			return "board/view";
	}
	
	@GetMapping("/edit/{boardId}")
	public void getEdit(@PathVariable int boardId,
	Model model) throws Exception{
		Board board = service.getBoard(boardId);
		model.addAttribute("board", board);
	}
	
	@PostMapping("/edit/{boardId}")
	public String postEdit(@RequestParam(value="page") int page,
			@Valid Board board, BindingResult result) throws Exception{
		
		if(result.hasErrors()) {
			return "board/edit";
		}
		
		if(service.update(board)) {
			return "redirect:../view/" + board.getBoardId() +
					"?page=" + page;
		}else {
			FieldError fieldError = new FieldError("board", "password",
												"비번이 일치하지 않음");
			
			result.addError(fieldError);
			return "board/edit";
		}

	}
	

	@DeleteMapping("/delete/{boardId}")
	@ResponseBody
	public ResponseEntity<Map<String, String>> delete(@PathVariable int boardId,
	@RequestParam(value = "password") String password)
	throws Exception {
		
		Map<String, String> map = new HashMap<>();
		
		if (service.delete(boardId, password)) {
			map.put("result", "success");
		} else {
//			json에서 필드는 result 값은  "비밀번호가 일치하지 않습니다."
			map.put("result", "비밀번호가 일치하지 않습니다.");
		}
		
		HttpHeaders headers = new HttpHeaders();
		headers.add("Content-Type", "application/json; charset=utf-8");
		return new ResponseEntity<Map<String, String>>(
		map, headers, HttpStatus.OK);
	}
}