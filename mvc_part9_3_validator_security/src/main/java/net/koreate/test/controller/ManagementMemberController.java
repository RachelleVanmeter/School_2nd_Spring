package net.koreate.test.controller;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import net.koreate.test.service.MemberService;

@Controller
@RequestMapping("/mngt/*")
public class ManagementMemberController {
	
	@Inject
	MemberService service;
	
	@GetMapping("main")
	public void main(Model model) throws Exception{
		// 회원 정보 리스트
		model.addAttribute("memberList",service.getMemberList());
	}
}
