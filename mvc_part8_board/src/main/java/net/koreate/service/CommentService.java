package net.koreate.service;

import java.util.Map;

import net.koreate.vo.CommentVO;

public interface CommentService {

	void addComment(CommentVO vo) throws Exception;
	Map<String, Object> listPage(int bno, int page) throws Exception;

}
