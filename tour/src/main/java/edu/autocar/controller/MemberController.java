package edu.autocar.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import edu.autocar.domain.Member;
import edu.autocar.service.MemberService;
import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
public class MemberController {
	@Autowired
	MemberService service;
	
	@GetMapping("/join")
	public String getJoin(Member member) throws Exception{
		return "member/join";
	}
	
	
	
}
