package net.koreate.comment.service;

import java.util.List;

import net.koreate.comment.vo.CommentVo;
import net.koreate.comment.vo.Criteria;
import net.koreate.comment.vo.PageMaker;

public interface CommentService {

	void addComment(CommentVo vo) throws Exception;

	List<CommentVo> commentList(int bno) throws Exception;

	void modifyComment(CommentVo vo) throws Exception;

	void removeComment(int cno) throws Exception;

	PageMaker getPageMaker(int bno, int page) throws Exception;

	List<CommentVo> commentListPage(int bno, Criteria cri) throws Exception;

}
