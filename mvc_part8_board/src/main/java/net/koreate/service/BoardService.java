package net.koreate.service;

import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;

import net.koreate.util.PageMaker;
import net.koreate.util.SearchCriteria;
import net.koreate.vo.BoardVO;

public interface BoardService {
	
	// 게시물 작성
	void registReply(BoardVO board) throws Exception;
	
	// 검색결과에 따른 페이징 처리된 게시물 리스트
	List<BoardVO> listReplyCriteria(SearchCriteria cri) throws Exception;
	
	// 페이징 블럭 정보 
	PageMaker getPageMaker(SearchCriteria cri) throws Exception;
	
	// 조회수 증가
	void updateCnt(int bno) throws Exception;
	
	// 게시물 정보
	BoardVO readReply(int bno) throws Exception;
	
	// 첨부 파일 목록
	List<String> getAttach(int bno) throws Exception;
}









