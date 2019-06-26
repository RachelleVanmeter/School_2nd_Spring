package net.koreate.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import net.koreate.vo.CommentVO;

public interface CommentDAO {

	@Insert("INSERT INTO tbl_comment(bno,commentText,commentAuth,uno) VALUES(#{bno},#{commentText},#{commentAuth},#{uno})")
	void addComment(CommentVO vo) throws Exception;

	@Select("SELECT count(*) FROM tbl_comment WHERE bno = #{bno}")
	int totalCount(int bno) throws Exception;

	@Select("SELECT * FROM tbl_comment WHERE bno = #{bno} ORDER BY cno DESC limit #{cri.pageStart} , #{cri.perPageNum}")
	List<CommentVO> listPage(Map<String, Object> paramMap) throws Exception;

}
