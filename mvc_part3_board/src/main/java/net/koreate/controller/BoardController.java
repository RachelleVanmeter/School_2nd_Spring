package net.koreate.controller;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import lombok.extern.slf4j.Slf4j;
import net.koreate.service.BoardService;
import net.koreate.vo.BoardVo;

@Controller
@RequestMapping("/board/*")
@Slf4j
public class BoardController {
	
	@Inject
	BoardService service;
	
	@GetMapping("/register")
	public void register() {
		log.info("get register called!!!");
	}
	
	@PostMapping("/register")
	public String register(BoardVo board) {
		log.info("post register called!!!");
		log.info("BoardVo : " + board);
		String msg = service.register(board);
		System.out.println(msg);
		return "home";
	}
	
	@GetMapping("/listAll")
	public void listAll(Model model) {
		log.info("get listAll called!!!");
		List<BoardVo> list = service.listAll();
		model.addAttribute("boardList", list);
	}
	
	@GetMapping("/read")
	public void read(@RequestParam("bno") int bno, Model model) {
		log.info("get read called!!! " + bno);
		model.addAttribute("board", service.read(bno));
	}
	
	@GetMapping("/modify")
	public void modify(@RequestParam("bno") int bno, Model model) {
		log.info("get modify called!!! " + bno);
		model.addAttribute("board", service.read(bno));
	}
	
	@PostMapping("/modify")
	public String modify(BoardVo board, RedirectAttributes rttr) {
		log.info("post modify called!!! " + board);
		String msg = service.modify(board);
		rttr.addFlashAttribute("result", msg);
		return "redirect:/board/read?bno=" + board.getBno();
	}
	
}
