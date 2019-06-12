package net.koreate.controller;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import lombok.extern.slf4j.Slf4j;
import net.koreate.service.BoardService;

@Controller
@RequestMapping("/sboard/*")
@Slf4j
public class SearchController {
	
	@Inject
	BoardService service;
	
	@GetMapping("/list")
	public String list(@RequestParam(name = "searchType", required = false) String searchType,
			@RequestParam(name = "keyword", required = false) String keyword) {
		log.info("get list call!!! " + searchType + " / " + keyword);
		return "sboard/listPage";
	}
}
