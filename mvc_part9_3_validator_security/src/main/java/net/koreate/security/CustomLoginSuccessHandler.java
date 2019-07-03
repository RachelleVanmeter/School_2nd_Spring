package net.koreate.security;

import java.io.IOException;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

import net.koreate.service.MemberService;
import net.koreate.vo.MemberVo;

public class CustomLoginSuccessHandler implements AuthenticationSuccessHandler {
	
	@Inject
	MemberService service;
	
	@Override
	public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
			Authentication authentication) throws IOException, ServletException {
		System.out.println("로그인 성공");
		CustomMember customMember = (CustomMember) authentication.getPrincipal();
		MemberVo member = customMember.getMember();
		System.out.println("MemberVo : " + member);
		
		System.out.println(customMember.getUsername());
		System.out.println(customMember.getPassword());
		System.out.println(customMember.getAuthorities());
		
		try {
			service.updateVisitDate(member.getU_id());
		} catch (Exception e) {
			e.printStackTrace();
		}
		response.sendRedirect("/");
	}

}
