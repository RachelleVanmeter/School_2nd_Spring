package net.koreate.dao;

import net.koreate.vo.MemberVo;

public interface MemberDao {
	
	MemberVo getMemberbyID(String u_id) throws Exception;
	
}
