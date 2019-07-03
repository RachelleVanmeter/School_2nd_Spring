package net.koreate.security;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;

import lombok.Getter;
import net.koreate.vo.AuthVo;
import net.koreate.vo.MemberVo;

@Getter
public class CustomMember extends User {
	private static final long serialVersionUID = 1L;
	private MemberVo member;
	
	public CustomMember(String username, String password, Collection<? extends GrantedAuthority> authorities) {
		super(username, password, authorities);
	}
	
	public CustomMember(MemberVo member) {
		super(member.getU_id(), member.getU_pw(), authorities(member.getAuthList()));
	}
	
	public static Collection<? extends GrantedAuthority> authorities(List<AuthVo> list) {
		List<GrantedAuthority> glist = new ArrayList<>();
		for (AuthVo auth : list) {
			glist.add(new SimpleGrantedAuthority(auth.getU_auth()));
		}
		return glist;
	}

}
