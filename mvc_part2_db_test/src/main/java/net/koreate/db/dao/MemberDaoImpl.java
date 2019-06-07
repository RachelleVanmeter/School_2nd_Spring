package net.koreate.db.dao;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import net.koreate.db.vo.MemberVo;

@Repository
public class MemberDaoImpl implements MemberDao {
	
	@Inject
	private SqlSession session;
	
	private String nameSpace = "net.koreate.mappers.MemberMapper";
	
	@Override
	public MemberVo readMember(String userId) {
		return session.selectOne(nameSpace + ".readMember", userId);
	}

	@Override
	public void insertMember(MemberVo memberVo) {
		System.out.println("insertMember : " + memberVo);
		session.insert(nameSpace + ".insertMember", memberVo);
	}

}
