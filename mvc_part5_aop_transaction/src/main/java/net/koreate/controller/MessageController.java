package net.koreate.controller;

import java.util.List;

import javax.inject.Inject;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.slf4j.Slf4j;
import net.koreate.service.MessageService;
import net.koreate.vo.MessageVo;
import net.koreate.vo.UserVo;

@Slf4j
@RestController
@RequestMapping("/messages/*")
public class MessageController {
	
	@Inject
	MessageService service;
	
	@PostMapping("/add")
	public ResponseEntity<String> addMessage(MessageVo message) {
		log.info("post message add call!!! : " + message);
		ResponseEntity<String> entity = null;
		
		try {
			service.addMessage(message);
			entity = new ResponseEntity<>("SUCCESS", HttpStatus.OK);
		} catch (Exception e) { entity = new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR); }
		
		return entity;
	}
	
	@GetMapping("/list")
	public ResponseEntity<List<MessageVo>> readList() {
		log.info("get message list call!!!");
		ResponseEntity<List<MessageVo>> entity = null;
		
		try {
			List<MessageVo> list = service.list();
			entity = new ResponseEntity<>(list, HttpStatus.OK);
		} catch (Exception e) { entity = new ResponseEntity<>(HttpStatus.BAD_REQUEST); }
		
		return entity;
	}
	
	@PatchMapping({ "/read/{mno}/{uid}", "/read/{mno}" })
	public ResponseEntity<Object> readMessage(@RequestBody(required = false) UserVo user,
			@PathVariable("mno") int mno,
			@PathVariable(name = "uid", required = false) String uid) {
		log.info("get message read call!!!");
		log.info("UserVo : " + user);
		log.info("mno : " + mno + " / before uid : " + uid);
		ResponseEntity<Object> entity = null;
		
		if (uid == null || uid.equals("")) uid = user.getUid();
		log.info("after uid : " + uid);
		
		try {
			entity = new ResponseEntity<>(service.readMessage(mno, uid), HttpStatus.OK);
		} catch (Exception e) { entity = new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST); }
		
		return entity;
	}
	
}
