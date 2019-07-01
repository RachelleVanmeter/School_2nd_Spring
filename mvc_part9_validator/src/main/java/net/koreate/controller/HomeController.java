package net.koreate.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import lombok.extern.slf4j.Slf4j;
import net.koreate.dto.LoginDto;
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
	public void login(String error, String success, Model model) {
		log.info("get user login call!!!");
		if (error != null) model.addAttribute("error", "로그인 실패");
		if (success != null) model.addAttribute("success", "로그인 성공");
	}
	
	@PostMapping("/user/loginPost")
	public String loginPost(LoginDto dto) {
		log.info("post user loginPost call!!!");
		
		if (dto.getU_id().equals("ktm06069@naver.com") && dto.getU_pw().equals("ktm06069")) {
			return "redirect:/user/login?success";
		} else {
			return "redirect:/user/login?error";
		}
	}
	
	@GetMapping("/user/join")
	public void join() {
		log.info("get user join call!!!");
	}
	
	@PostMapping("/user/joinPost")
	public String joinPost(MemberVo member) {
		log.info("post user joinPost call!!!");
		log.warn("MemberVo : " + member);
		return "redirect:/";
	}
	
	@GetMapping("/user/joinVal")
	public String joinVal() {
		log.info("get user joinVal call!!!");
		return "user/joinVal";
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
