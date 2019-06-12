package net.koreate.controller;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.extern.slf4j.Slf4j;
import net.koreate.service.BoardService;
import net.koreate.vo.SearchCriteria;

@Controller
@RequestMapping("/sboard/*")
@Slf4j
public class SearchController {
	
	@Inject
	BoardService service;
	
	@GetMapping("/list")
	public String list(SearchCriteria cri) {
		log.info("get list call!!! " + cri);
		return "sboard/listPage";
	}
}
