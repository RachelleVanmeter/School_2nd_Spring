package net.koreate.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import net.koreate.dao.MessageDao;
import net.koreate.dao.UserDao;
import net.koreate.vo.MessageVo;
import net.koreate.vo.UserVo;

@Service
public class MessageServiceImpl implements MessageService {
	
	@Inject
	MessageDao mDao;
	
	@Inject
	UserDao uDao;

	@Override
	public void addMessage(MessageVo message) throws Exception {
		UserVo user = new UserVo();
		user.setUid(message.getSender());
		user.setUpoint(10);
		uDao.updatePoint(user);
		
		mDao.create(message);
	}

	@Override
	public MessageVo readMessage(int mno, String uid) throws Exception {
		return null;
	}

	@Override
	public List<MessageVo> list() throws Exception {
		return null;
	}
	
}
