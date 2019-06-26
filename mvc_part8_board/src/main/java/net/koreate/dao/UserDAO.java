package net.koreate.dao;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import net.koreate.vo.LoginDTO;
import net.koreate.vo.UserVO;

public interface UserDAO {

	@Insert("INSERT INTO tbl_user(uid,upw,uname) VALUES(#{uid},#{upw},#{uname})")
	void signUp(UserVO vo) throws Exception;

	@Select("SELECT * FROM tbl_user WHERE uid = #{uid}")
	UserVO getUserById(String uid) throws Exception;

	@Select("SELECT * FROM tbl_user WHERE uid = #{uid} AND upw = #{upw}")
	UserVO signIn(LoginDTO dto) throws Exception;

}
