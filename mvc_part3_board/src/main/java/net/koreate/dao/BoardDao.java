package net.koreate.dao;

import java.util.List;

import net.koreate.vo.BoardVo;
import net.koreate.vo.Criteria;
import net.koreate.vo.SearchCriteria;

public interface BoardDao {

	int create(BoardVo board);
	List<BoardVo> listAll();
	BoardVo read(int bno);
	void updateViewCnt(int bno);
	int update(BoardVo board);
	int delete(int bno);
	List<BoardVo> listCri(Criteria cri);
	int totalCount();
	int searchListCount(SearchCriteria cri);
	List<BoardVo> searchList(SearchCriteria cri);

}
