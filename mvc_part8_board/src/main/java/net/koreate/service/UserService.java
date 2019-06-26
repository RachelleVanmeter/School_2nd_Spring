package net.koreate.service;

import net.koreate.vo.LoginDTO;
import net.koreate.vo.UserVO;

public interface UserService {

	void signUp(UserVO vo) throws Exception;
	UserVO signIn(LoginDTO dto) throws Exception;
	UserVO getUserById(String uid) throws Exception;

}
