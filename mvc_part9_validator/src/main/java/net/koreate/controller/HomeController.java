package net.koreate.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import lombok.extern.slf4j.Slf4j;
import net.koreate.vo.MemberVo;

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
	
	@PostMapping("/user/joinPost")
	public void joinPost(MemberVo member) {
		log.info("post user joinPost call!!!");
		log.warn("MemberVo : " + member);
	}
	
	@GetMapping("/user/joinVal")
	public String joinVal() {
		log.info("get user joinVal call!!!");
		return "user/join";
	}
	
	@PostMapping("/user/uIdCheck")
	@ResponseBody
	public boolean uIdCheck(String u_id) {
		log.info("post user uIdCheck call!!!");
		boolean isCheckId = false;
		if (u_id != null && !u_id.equals("ktm06069@naver.com")) isCheckId = true;
		return isCheckId;
	}
	
}
