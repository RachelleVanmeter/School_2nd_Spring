package net.koreate.controller;

import javax.inject.Inject;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import net.koreate.dao.MemberDao;
import net.koreate.vo.MemberVo;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {
	"classpath:context/root/root-context.xml"
})
public class App {
	
	@Inject
	MemberDao dao;
	
	@Test
	public void testGetMemberbyID() throws Exception {
		MemberVo member  = dao.getMemberbyID("aaa@aaa.com");
		if (member != null) {
			System.out.println(member);
		} else {
			System.out.println("존재하지 않음");
		}
	}
	
}
