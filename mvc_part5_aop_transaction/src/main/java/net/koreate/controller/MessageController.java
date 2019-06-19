package net.koreate.controller;

import java.util.List;

import javax.inject.Inject;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.slf4j.Slf4j;
import net.koreate.service.MessageService;
import net.koreate.vo.MessageVo;

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
	
	@GetMapping({ "/read/{mno}/{uid}", "/read/{mno}" })
	public ResponseEntity<Object> readMessage() {
		log.info("get message read call!!!");
		ResponseEntity<Object> entity = null;
		
		return entity;
	}
	
}
