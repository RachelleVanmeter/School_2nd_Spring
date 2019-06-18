package net.koreate.comment.service;

import java.util.List;

import net.koreate.comment.vo.CommentVO;
import net.koreate.comment.vo.Criteria;
import net.koreate.comment.vo.PageMaker;

public interface CommentService {

	void addComment(CommentVO vo) throws Exception;
	List<CommentVO> commentList(int bno) throws Exception;
	void modifyComment(CommentVO vo) throws Exception;
	void removeComment(int cno) throws Exception;
	PageMaker getPageMaker(int bno, int page) throws Exception;
	List<CommentVO> commentListPage(int bno, Criteria cri) throws Exception;

}
