package net.koreate.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import net.koreate.dao.BoardDao;
import net.koreate.vo.BoardVo;
import net.koreate.vo.Criteria;

@Service
public class BoardServiceImpl implements BoardService {
	
	@Inject
	BoardDao dao;
	
	@Override
	public String register(BoardVo board) {
		return getResult(dao.create(board));
	}

	@Override
	public List<BoardVo> listAll() {
		return dao.listAll();
	}

	@Override
	public BoardVo read(int bno) {
		return dao.read(bno);
	}

	@Override
	public void updateViewCnt(int bno) {
		dao.updateViewCnt(bno);
	}

	@Override
	public String modify(BoardVo board) {
		return getResult(dao.update(board));
	}

	@Override
	public String remove(int bno) {
		return getResult(dao.delete(bno));
	}
	
	@Override
	public List<BoardVo> listCri(Criteria cri) {
		return dao.listCri(cri);
	}
	
	@Override
	public int totalCount() {
		return dao.totalCount();
	}
	
	public String getResult(int result) {
		String msg = "FAIL";
		if (result > 0) msg = "SUCCESS";
		return msg;
	}

}
