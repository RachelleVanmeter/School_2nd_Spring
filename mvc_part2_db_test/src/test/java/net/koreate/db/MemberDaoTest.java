package net.koreate.db;

import javax.inject.Inject;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import net.koreate.db.dao.MemberDao;
import net.koreate.db.vo.MemberVo;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({ "file:src/main/webapp/WEB-INF/spring/**/root-context.xml" })
public class MemberDaoTest {

	@Inject
	MemberDao dao;

	public void testInsertTest() {
		System.out.println("dao instance : " + dao);
		MemberVo memberVo = new MemberVo();
		memberVo.setUserid("user01");
		memberVo.setUserpw("pass01");
		memberVo.setUsername("김태민");
		dao.insertMember(memberVo);
	}

	@Test
	public void testReadTest() {
		System.out.println("dao instance : " + dao);
		System.out.println("readMember : " + dao.readMember("user01"));
	}

}
