package net.koreate.service;

import net.koreate.vo.MemberVo;

public interface MemberService {
	
	void memberJoin(MemberVo member) throws Exception;
	boolean getMemberbyID(String u_id) throws Exception;
	void updateVisitDate(String u_id) throws Exception;
	
}
