package net.koreate.dao;

import java.util.List;

import net.koreate.vo.BoardVo;
import net.koreate.vo.Criteria;

public interface BoardDao {

	String register(BoardVo board);

	List<BoardVo> listPage(Criteria cri);

	BoardVo readPage(int bno);

	String modify(BoardVo board);

	String remove(int bno);

	void updateViewCnt(int bno);

	int totalCount();

}
