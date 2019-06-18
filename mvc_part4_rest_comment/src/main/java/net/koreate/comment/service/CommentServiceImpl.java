package net.koreate.comment.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import net.koreate.comment.dao.CommentDao;
import net.koreate.comment.vo.CommentVo;
import net.koreate.comment.vo.Criteria;
import net.koreate.comment.vo.PageMaker;

@Service
public class CommentServiceImpl implements CommentService {

	@Inject
	CommentDao dao;

	@Override
	public void addComment(CommentVo vo) throws Exception {
		dao.addComment(vo);
	}

	@Override
	public List<CommentVo> commentList(int bno) throws Exception {
		return dao.list(bno);
	}

	@Override
	public void modifyComment(CommentVo vo) throws Exception {
		dao.update(vo);
	}

	@Override
	public void removeComment(int cno) throws Exception {
		dao.delete(cno);
	}

	@Override
	public PageMaker getPageMaker(int bno, int page) throws Exception {
		Criteria cri = new Criteria();
		cri.setPage(page);
		cri.setPerPageNum(20);

		int commentListCount = dao.count(bno);
		System.out.println(commentListCount);
		PageMaker pageMaker = new PageMaker();
		pageMaker.setCri(cri);
		pageMaker.setTotalCount(commentListCount);
		return pageMaker;
	}

	@Override
	public List<CommentVo> commentListPage(int bno, Criteria cri) throws Exception {
		Map<String, Object> map = new HashMap<>();
		map.put("bno", bno);
		map.put("cri", cri);
		return dao.listPage(map);
	}

}
