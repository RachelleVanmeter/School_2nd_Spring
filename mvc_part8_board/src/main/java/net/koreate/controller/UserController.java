package net.koreate.controller;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import net.koreate.service.UserService;
import net.koreate.vo.LoginDTO;
import net.koreate.vo.UserVO;

@Controller
@RequestMapping("/user")
public class UserController {

	@Inject
	UserService us;

	@GetMapping("/signIn")
	public String signIn() {
		return "/user/signIn";
	}

	@RequestMapping("/signUp")
	public String signUp() {
		return "/user/signUp";
	}

	@PostMapping("/signUpPost")
	public String signUpPost(UserVO vo, RedirectAttributes rttr) throws Exception {
		System.out.println("signPost UserVO" + vo);
		us.signUp(vo);
		rttr.addFlashAttribute("message", "회원가입성공");
		return "redirect:/user/signIn";
	}

	@PostMapping("/signInPost")
	public ModelAndView signInPost(LoginDTO dto, ModelAndView mav) {
		mav.addObject("loginDTO", dto);
		mav.setViewName("redirect:/");
		return mav;
	}

}
