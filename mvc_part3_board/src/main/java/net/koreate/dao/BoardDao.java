package net.koreate.dao;

import java.util.List;

import net.koreate.vo.BoardVo;

public interface BoardDao {
	
	int create(BoardVo board);
	List<BoardVo> listAll();
	BoardVo read(int bno);
	void updateViewCnt(int bno);
	int update(BoardVo board);
	int delete(int bno);
	
}
