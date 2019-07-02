package net.koreate.service;

import java.util.List;

import net.koreate.vo.BoardVo;
import net.koreate.vo.Criteria;
import net.koreate.vo.PageMaker;

public interface BoardService {

	String register(BoardVo board);

	List<BoardVo> listPage(Criteria cri);

	BoardVo readPage(int bno);

	String modify(BoardVo board);

	String remove(int bno);

	void updateViewCnt(int bno);

	PageMaker getPageMaker(Criteria cri);

}
