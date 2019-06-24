package net.koreate.controller;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import net.koreate.dao.UserDAO;
import net.koreate.vo.UserVO;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:context/root-context.xml" })
public class SqlSessionTest {

	@Inject
	SqlSession session;

	@Inject
	UserDAO dao;

	@Test
	public void testSqlSession() {
		System.out.println("session connection : " + session.getConnection());
		System.out.println("UerDAO : " + dao);
		UserVO vo = new UserVO();
		vo.setUid("id005");
		vo.setUpw("pw005");
		vo.setUname("bbb");
		try {
			dao.signUp(vo);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
