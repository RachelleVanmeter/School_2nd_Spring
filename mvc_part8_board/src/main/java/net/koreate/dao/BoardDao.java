package net.koreate.dao;

import java.util.List;

import net.koreate.util.SearchCriteria;
import net.koreate.vo.BoardVO;

public interface BoardDAO {

	void register(BoardVO board) throws Exception;
	void updateOrigin() throws Exception;
	void addAttach(String fullName) throws Exception;
	List<BoardVO> listReplyCriteria(SearchCriteria cri) throws Exception;
	int listReplyCount(SearchCriteria cri) throws Exception;
	void updateCnt(int bno) throws Exception;
	BoardVO readReply(int bno) throws Exception;
	List<String> getAttach(int bno) throws Exception;

}
