package net.koreate.service;

import java.util.List;

import net.koreate.vo.MessageVo;

public interface MessageService {
	
	void addMessage(MessageVo message) throws Exception;
	MessageVo readMessage(int mno, String uid) throws Exception;
	List<MessageVo> list() throws Exception;
	
}
