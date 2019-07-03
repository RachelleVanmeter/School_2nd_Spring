package net.koreate.security;

import javax.inject.Inject;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import net.koreate.dao.MemberDao;
import net.koreate.vo.MemberVo;

public class CustomUserDetailsService implements UserDetailsService {

	@Inject
	MemberDao dao;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		MemberVo member = null;
		try {
			member = dao.getMemberbyID(username);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return member == null ? null : new CustomMember(member);
	}

}
