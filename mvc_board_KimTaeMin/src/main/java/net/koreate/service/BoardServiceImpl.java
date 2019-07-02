package net.koreate.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import net.koreate.dao.BoardDao;
import net.koreate.vo.BoardVo;
import net.koreate.vo.Criteria;
import net.koreate.vo.PageMaker;

@Service
public class BoardServiceImpl implements BoardService {

	@Inject
	BoardDao dao;

	@Override
	public String register(BoardVo board) {
		return dao.register(board);
	}

	@Override
	public List<BoardVo> listPage(Criteria cri) {
		return dao.listPage(cri);
	}

	@Override
	public BoardVo readPage(int bno) {
		return dao.readPage(bno);
	}

	@Override
	public String modify(BoardVo board) {
		return dao.modify(board);
	}

	@Override
	public String remove(int bno) {
		return dao.remove(bno);
	}

	@Override
	public void updateViewCnt(int bno) {
		dao.updateViewCnt(bno);
	}

	@Override
	public PageMaker getPageMaker(Criteria cri) {
		int totalCount = dao.totalCount();
		PageMaker pageMaker = new PageMaker();
		pageMaker.setCri(cri);
		pageMaker.setTotalCount(totalCount);
		return pageMaker;
	}

}
