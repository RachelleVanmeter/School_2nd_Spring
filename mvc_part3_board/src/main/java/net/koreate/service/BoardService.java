package net.koreate.service;

import java.util.List;

import net.koreate.vo.BoardVo;

public interface BoardService {
	
	String register(BoardVo board);
	List<BoardVo> listAll();
	BoardVo read(int bno);
	void updateViewCnt(int bno);
	String modify(BoardVo board);
	String remove(int bno);
	
}
