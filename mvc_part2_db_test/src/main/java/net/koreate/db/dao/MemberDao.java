package net.koreate.db.dao;

import net.koreate.db.vo.MemberVo;

public interface MemberDao {

	public MemberVo readMember(String userId);
	public void insertMember(MemberVo memberVo);

}
