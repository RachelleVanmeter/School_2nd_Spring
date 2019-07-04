package net.koreate.test.dao;

import java.util.List;

import net.koreate.test.vo.ValidationMemberVO;

public interface MemberDAO {
	
	ValidationMemberVO getMemberByID(String u_id);
	
	void memberJoin(ValidationMemberVO vo);

	void insertAuth(String u_id);

	void updateVisitDate(String u_id);

	List<ValidationMemberVO> getMemberList();

}
