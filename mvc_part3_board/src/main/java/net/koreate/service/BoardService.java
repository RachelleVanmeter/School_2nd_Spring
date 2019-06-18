package net.koreate.service;

import java.util.List;

import net.koreate.vo.BoardVo;
import net.koreate.vo.Criteria;
import net.koreate.vo.PageMaker;
import net.koreate.vo.SearchCriteria;

public interface BoardService {

	String register(BoardVo board);
	List<BoardVo> listAll();
	BoardVo read(int bno);
	void updateViewCnt(int bno);
	String modify(BoardVo board);
	String remove(int bno);
	List<BoardVo> listCri(Criteria cri);
	int totalCount();
	int searchListCount(SearchCriteria cri);
	List<BoardVo> searchList(SearchCriteria cri);
	PageMaker getPageMaker(SearchCriteria cri);

}
