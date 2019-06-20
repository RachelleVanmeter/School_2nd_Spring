package net.koreate.controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class UploadController {
	
	@Resource(name = "uploadPath")
	String uploadPath;
	
	@GetMapping("/")
	public String home() {
		log.info("get home view call!!!");
		return "home";
	}
	
	@GetMapping("/uploadForm")
	public void uploadForm() {
		log.info("get uploadForm view call!!!");
	}
	
}
