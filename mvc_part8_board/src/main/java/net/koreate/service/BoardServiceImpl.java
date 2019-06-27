package net.koreate.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import net.koreate.dao.BoardDAO;
import net.koreate.util.PageMaker;
import net.koreate.util.SearchCriteria;
import net.koreate.vo.BoardVO;

@Service
public class BoardServiceImpl implements BoardService {

	@Inject
	BoardDAO dao;
	
	@Override
	public void registReply(BoardVO board) throws Exception {
		// 게시물 등록  / origin update / 첨부파일 등록
		dao.register(board);
		dao.updateOrigin();
		
		String[] files = board.getFiles();
		
		if(files == null) {return;}
		
		for(String fullName : files) {
			dao.addAttach(fullName);
		}
		System.out.println("register 작업 완료");
	}

	@Override
	public List<BoardVO> listReplyCriteria(SearchCriteria cri) throws Exception {
		List<BoardVO> list = dao.listReplyCriteria(cri);
		return list;
	}

	@Override
	public PageMaker getPageMaker(SearchCriteria cri) throws Exception {
		PageMaker pageMaker = new PageMaker();
		pageMaker.setCri(cri);
		pageMaker.setTotalCount(dao.listReplyCount(cri));
		return pageMaker;
	}

	@Override
	public void updateCnt(int bno) throws Exception {
		dao.updateCnt(bno);
	}

	@Override
	public BoardVO readReply(int bno) throws Exception {
		return dao.readReply(bno);
	}

	@Override
	public List<String> getAttach(int bno) throws Exception {
		return dao.getAttach(bno);
	}
	
	
	
	
	
	
	
	
	

}
