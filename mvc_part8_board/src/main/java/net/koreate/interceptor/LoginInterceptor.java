package net.koreate.interceptor;

import javax.inject.Inject;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.ui.ModelMap;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import net.koreate.service.UserService;
import net.koreate.vo.LoginDTO;
import net.koreate.vo.UserVO;

public class LoginInterceptor extends HandlerInterceptorAdapter{
	
	@Inject
	UserService service;
	

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		HttpSession session = request.getSession();
		
		// session 에 로그인된 회원정보 userInfo로 저장
		
		if(session.getAttribute("userInfo") != null) {
			session.removeAttribute("userInfo");
		}
		
		return true;
	}

	@Override
	public void postHandle(
			HttpServletRequest request, 
			HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		
		ModelMap modelObj = modelAndView.getModelMap();
		
		LoginDTO dto = (LoginDTO)modelObj.get("loginDTO");
		
		System.out.println("LoginInterceptor postHandle : " + dto);
		
		UserVO vo = service.signIn(dto);
		
		if(vo != null) {
			request.getSession().setAttribute("userInfo", vo);
			
			if(dto.isUserCookie()) {
				Cookie cookie = new Cookie("signInCookie",vo.getUid());
				cookie.setPath("/");
				cookie.setMaxAge(60*60*24*15);
				response.addCookie(cookie);
			}
		}else {
			modelAndView.addObject("message","회원정보가 일치하지 않습니다.");
			modelAndView.setViewName("/user/signIn");
		}
	}
	
	

}
