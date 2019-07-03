package net.koreate.security.user;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;

import lombok.Getter;
import net.koreate.vo.AuthVo;
import net.koreate.vo.MemberVo;

// principal
// principal.member
@Getter
public class CustomUser extends User {
	private static final long serialVersionUID = 1L;
	private MemberVo member;

	public CustomUser(String username, String password, Collection<? extends GrantedAuthority> authorities) {
		super(username, password, authorities);
	}

	public CustomUser(MemberVo vo) {
		super(vo.getUid(), vo.getUpw(), customAuthorities(vo.getAuthList()));
		this.member = vo;
	}

	private static Collection<? extends GrantedAuthority> customAuthorities(List<AuthVo> list) {
		List<GrantedAuthority> authorities = new ArrayList<>();
		for (AuthVo auth : list) {
			authorities.add(new SimpleGrantedAuthority(auth.getAuth()));
		}
		return authorities;
	}
	
}
