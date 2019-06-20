package net.koreate.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
	@Transactional
	public void addMessage(MessageVo message) throws Exception {
		UserVo user = new UserVo();
		user.setUid(message.getSender());
		user.setUpoint(10);
		uDao.updatePoint(user);
		
		mDao.create(message);
	}

	@Override
	public MessageVo readMessage(int mno, String uid) throws Exception {
		mDao.updateMessage(mno);
		UserVo user = new UserVo();
		
		user.setUid(uid);
		user.setUpoint(5);
		uDao.updatePoint(user);
		
		MessageVo message = mDao.readMessage(mno);
		return message;
	}

	@Override
	public List<MessageVo> list() throws Exception {
		return mDao.list();
	}
	
}
