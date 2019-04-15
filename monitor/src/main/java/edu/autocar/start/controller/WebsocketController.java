package edu.autocar.start.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class WebsocketController {
	
	@GetMapping("/socketTest")
	public String echo() {
		
		return "socketTest";
	}
	
	@GetMapping("/carMsg")
	public String carmessage() {
		
		return "carMsg";
	}
	
	
	
}
