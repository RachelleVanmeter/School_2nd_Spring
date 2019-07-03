package net.koreate.service;

import javax.inject.Inject;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import net.koreate.dao.MemberDao;
import net.koreate.vo.MemberVo;

@Service
public class MemberServiceImpl implements MemberService {
	
	@Inject
	MemberDao dao;
	
	@Inject
	PasswordEncoder encoder;
	
	@Override
	@Transactional
	public void memberJoin(MemberVo member) throws Exception {
		// 회원등록, 회원 기본 권한 제공(ROLE_USER) 일반 사용자
		// 회원 등록
		System.out.println("before pass : " + member.getU_pw());
		member.setU_pw(encoder.encode(member.getU_pw()));
		System.out.println("after pass : " + member.getU_pw());
		dao.memberJoin(member);
		
		// 권한 부여
		dao.insertAuth(member.getU_id());
	}
	
	@Override
	public boolean getMemberbyID(String u_id) throws Exception {
		return dao.getMemberbyID(u_id) == null ? true : false;
	}

	@Override
	public void updateVisitDate(String u_id) throws Exception {
		dao.updateVisitDate(u_id);
	}
	
}
