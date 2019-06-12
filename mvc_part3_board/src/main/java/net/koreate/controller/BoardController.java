package net.koreate.controller;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import lombok.extern.slf4j.Slf4j;
import net.koreate.service.BoardService;
import net.koreate.vo.BoardVo;
import net.koreate.vo.Criteria;
import net.koreate.vo.PageMaker;

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
	public String register(BoardVo board, RedirectAttributes rttr) {
		log.info("post register called!!!");
		log.info("BoardVo : " + board);
		String msg = service.register(board);
		System.out.println(msg);
		rttr.addFlashAttribute("result", msg);
		return "redirect:/board/listAll";
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
	public String modify(BoardVo board, @ModelAttribute("page") int page, RedirectAttributes rttr) {
		log.info("post modify called!!! " + board);
		String msg = service.modify(board);
		rttr.addFlashAttribute("result", msg);
		return "redirect:/board/readDetail?bno=" + board.getBno() + "&page=" + page;
	}
	
	@PostMapping("/delete")
	public String delete(@RequestParam("bno") int bno, @ModelAttribute("page") int page, RedirectAttributes rttr) {
		log.info("get delete called!!! " + bno);
		String msg = service.remove(bno);
		rttr.addFlashAttribute("result", msg);
		return "redirect:/board/listPage?page=" + page;
	}
	
	@GetMapping("/listCri")
	public String listCri(Criteria cri, Model model) {
		log.info("get listCri called!!! " + cri);
		model.addAttribute("boardList", service.listCri(cri));
		return "board/listAll";
	}
	
	@GetMapping("/listPage")
	public void listPage(Criteria cri, Model model) {
		log.info("get listPage called!!! " + cri);
		List<BoardVo> boardList = service.listCri(cri);
		model.addAttribute("boardList", boardList);
		
		PageMaker pageMaker = new PageMaker();
		pageMaker.setCri(cri);
		pageMaker.setTotalCount(service.totalCount());
		log.info("pageMaker : " + pageMaker);
		model.addAttribute(pageMaker);
	}
	
	@GetMapping("/readPage")
	public String readPage(@RequestParam("bno") int bno, @RequestParam("page") int page, RedirectAttributes rttr) {
		log.info("get readPage called!!! " + bno);
		service.updateViewCnt(bno);
		rttr.addAttribute("bno", bno);
		rttr.addAttribute("page", page);
		return "redirect:/board/readDetail";
	}
	
	@GetMapping("/readDetail")
	public String readDetail(@ModelAttribute("bno") int bno, @ModelAttribute("page") int page, Model model) {
		log.info("get readDetail called!!! " + bno);
		model.addAttribute("board", service.read(bno));
		return "/board/readPage";
	}
	
}
