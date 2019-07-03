package net.koreate.controller;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import lombok.extern.slf4j.Slf4j;
import net.koreate.service.MemberService;
import net.koreate.vo.MemberVo;

@Slf4j
@Controller
public class UserController {
	
	@Inject
	MemberService service;

	@GetMapping("/user/login")
	public void login() {
		log.info("get user login call!!!");
	}

	@GetMapping("/user/join")
	public void join() {
		log.info("get user join call!!!");
	}

	@PostMapping("/user/joinPost")
	public String joinPost(MemberVo member) throws Exception {
		log.info("post user joinPost call!!!");
		log.warn("MemberVo : " + member);
		service.memberJoin(member);
		return "redirect:/user/login";
	}

	@GetMapping("/user/joinVal")
	public String joinVal() {
		log.info("get user joinVal call!!!");
		return "user/joinVal";
	}

	@PostMapping("/user/uIdCheck")
	@ResponseBody
	public boolean uIdCheck(String u_id) throws Exception {
		log.info("post user uIdCheck call!!!");
		return service.getMemberbyID(u_id);
	}
}
