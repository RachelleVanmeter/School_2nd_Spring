package net.koreate.service;

import java.util.List;

import net.koreate.util.PageMaker;
import net.koreate.util.SearchCriteria;
import net.koreate.vo.BoardVO;

public interface BoardService {

	void registReply(BoardVO board) throws Exception;
	List<BoardVO> listReplyCriteria(SearchCriteria cri) throws Exception;
	PageMaker getPageMaker(SearchCriteria cri) throws Exception;
	void updateCnt(int bno) throws Exception;
	BoardVO readReply(int bno) throws Exception;
	List<String> getAttach(int bno) throws Exception;
	
}
