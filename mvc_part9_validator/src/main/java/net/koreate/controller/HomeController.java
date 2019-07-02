package net.koreate.controller;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

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

	@Inject
	SessionEventListener listener;

	@GetMapping("/")
	public String home() {
		log.info("get home call!!!");
		return "home";
	}

	@GetMapping("/user/login")
	public void login(String error, String success, Model model) {
		log.info("get user login call!!!");
		if (error != null)
			model.addAttribute("error", "로그인 실패");
		if (success != null)
			model.addAttribute("success", "로그인 성공");
	}

	@PostMapping("/user/loginPost")
	public String loginPost(LoginDto dto, HttpSession session) {
		log.info("post user loginPost call!!!");
		MemberVo member = new MemberVo();
		member.setU_id(dto.getU_id());
		member.setU_pw(dto.getU_pw());

		boolean isSession = listener.duplicatedSession(dto.getU_id(), session.getId());

		if (isSession) {
			System.out.println("중복 제거");
		} else {
			System.out.println("첫 로그인");
		}
		session.setAttribute("userInfo", member);
		return "redirect:/";
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
		if (u_id != null && !u_id.equals("ktm06069@naver.com"))
			isCheckId = true;
		return isCheckId;
	}

}
