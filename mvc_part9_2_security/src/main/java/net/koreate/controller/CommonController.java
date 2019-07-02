package net.koreate.controller;

import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class CommonController {
	
	@GetMapping("/errorForbidden")
	public void errorForbidden(Authentication auth, Model model) {
		log.error("errorForbidden : " + auth);
		model.addAttribute("msg", "접근권한이 없습니다.");
	}
	
	@GetMapping("/login")
	public ModelAndView login(ModelAndView mav) {
		log.error("get login call!!!");
		mav.setViewName("/user/login");
		return mav;
	}
	
	@GetMapping("/logout")
	public String logout() {
		log.error("get logout call!!!");
		return "user/logout";
	}
	
}
