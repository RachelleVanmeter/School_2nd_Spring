package net.koreate.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class HomeController {
	
	@GetMapping("/")
	public String home() {
		log.info("get home call!!!");
		return "home";
	}
	
	@GetMapping("/user/login")
	public void login() {
		log.info("get user login call!!!");
	}
	
	@GetMapping("/user/join")
	public void join() {
		log.info("get user join call!!!");
	}
	
	@GetMapping("/user/joinVal")
	public String joinVal() {
		log.info("get user joinVal call!!!");
		return "user/join";
	}
	
}
