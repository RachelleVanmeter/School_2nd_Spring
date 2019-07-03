package net.koreate.dao;

import net.koreate.vo.MemberVo;

public interface MemberDao {
	
	MemberVo getMemberbyID(String u_id) throws Exception;
	void memberJoin(MemberVo member) throws Exception;
	void insertAuth(String u_id) throws Exception;
	void updateVisitDate(String u_id) throws Exception;
	
}
