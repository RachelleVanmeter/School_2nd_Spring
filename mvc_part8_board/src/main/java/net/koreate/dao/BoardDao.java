package net.koreate.dao;

import java.util.List;

import net.koreate.util.SearchCriteria;
import net.koreate.vo.BoardVO;

public interface BoardDAO {
	
	//게시물 등록
	void register(BoardVO board) throws Exception;
	
	// 원본글 자신의 origin update
	void updateOrigin()throws Exception;
	
	// 첨부파일 등록
	void addAttach(String fullName) throws Exception;
	
	// 검색된 게시물 항목 중 페이징 처리된 게시물 리스트 
	List<BoardVO> listReplyCriteria(SearchCriteria cri) throws Exception;
	
	// 검색된 게시물의 총 개수
	int listReplyCount(SearchCriteria cri) throws Exception;
	
	// 조회수 업데이트
	void updateCnt(int bno) throws Exception;
	
	// 게시물 정보
	BoardVO readReply(int bno) throws Exception;	
	
	// 첨부 파일 목록 
	List<String> getAttach(int bno) throws Exception;
	
}
