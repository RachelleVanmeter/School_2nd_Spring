package net.koreate.dao;

import net.koreate.vo.MemberVo;

public interface MemberDao {
	
	MemberVo read(String uid) throws Exception;
}
