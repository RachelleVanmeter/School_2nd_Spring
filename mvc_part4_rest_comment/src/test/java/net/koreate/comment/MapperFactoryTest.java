package net.koreate.comment;

import javax.inject.Inject;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import net.koreate.comment.dao.CommentDao;
import net.koreate.comment.vo.CommentVo;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {
	/* "file:src/main/resources/context/root-context.xml" */
	"classpath:context/root-context.xml"
})
public class MapperFactoryTest {

	@Inject
	CommentDao dao;

	@Test
	public void testSqlSession() throws Exception {
		System.out.println(dao);
		CommentVo comment = new CommentVo();
		comment.setBno(1);
		comment.setCommentText("첫번째 댓글");
		comment.setCommentAuth("최기근");
		dao.addComment(comment);
	}
}
