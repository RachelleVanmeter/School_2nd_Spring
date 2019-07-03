package net.koreate.security;

import javax.inject.Inject;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import net.koreate.dao.MemberDao;
import net.koreate.security.user.CustomUser;
import net.koreate.vo.MemberVo;

public class CustomUserDetailService implements UserDetailsService {

	@Inject
	MemberDao dao;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		MemberVo member = null;
		System.out.println("loadUserByUsername");
		try {
			member = dao.read(username);
			System.out.println("quired by Member : " + member);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return member == null ? null : new CustomUser(member);
	}

}
