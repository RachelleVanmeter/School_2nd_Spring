package net.koreate.dao;

import java.util.List;

import net.koreate.vo.MessageVo;

public interface MessageDao {

	void create(MessageVo message) throws Exception;

	void updateMessage(int mno) throws Exception;

	MessageVo readMessage(int mno) throws Exception;

	List<MessageVo> list() throws Exception;

}
