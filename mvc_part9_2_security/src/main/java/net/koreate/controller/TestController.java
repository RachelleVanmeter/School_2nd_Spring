package net.koreate.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequestMapping("/test/*")
public class TestController {
	
	@GetMapping("/all")
	public void all() {
		log.info("get test all call!!!");
	}
	
	@GetMapping("/memberShip")
	public void memberShip() {
		log.info("get test memberShip call!!!");
	}
	
	@GetMapping("/master")
	public void master() {
		log.info("get test master call!!!");
	}
	
}
