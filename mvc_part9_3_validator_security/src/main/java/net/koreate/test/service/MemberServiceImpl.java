package net.koreate.test.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import net.koreate.test.dao.MemberDAO;
import net.koreate.test.vo.ValidationMemberVO;

@Service
public class MemberServiceImpl implements MemberService{
	
	@Inject 
	MemberDAO dao;
	
	@Inject
	PasswordEncoder encoder;
	
	@Override
	public boolean getMemberByID(String u_id) throws Exception {
		return dao.getMemberByID(u_id) == null ? true : false;
	}

	@Override
	public void updateVisitDate(String u_id) {
		dao.updateVisitDate(u_id);
	}




	@Transactional
	@Override
	public void memberJoin(ValidationMemberVO vo) throws Exception {
		// 회원등록   , 회원 기본 권한 제공(ROLE_USER) 일반 사용자
		
		// 회원등록
		System.out.println("before pass: "+vo.getU_pw());
		vo.setU_pw(encoder.encode(vo.getU_pw()));
		System.out.println("adter pass: "+vo.getU_pw());
		dao.memberJoin(vo);
		
		// 권한 부여
		dao.insertAuth(vo.getU_id());		
		
	}

	@Override
	public List<ValidationMemberVO> getMemberList() throws Exception {
		
		return dao.getMemberList();
	}
	
	
	
	
	
}
