package net.koreate.controller;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
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
		log.info("get register call!!!");
	}
	
	@PostMapping("/register")
	public String register(BoardVo board, RedirectAttributes rttr) {
		log.info("post register call!!!");
		String msg = service.register(board);
		rttr.addFlashAttribute("result", msg);
		return "redirect:/board/listPage";
	}
	
	@GetMapping("/listPage")
	public void listPage(Criteria cri, Model model) {
		log.info("get listPage call!!! " + cri);
		model.addAttribute("boardList", service.listPage(cri));
		model.addAttribute("cri", cri);
		PageMaker pageMaker = service.getPageMaker(cri);
		model.addAttribute("pageMaker", pageMaker);
	}
	
	@GetMapping("/readPage")
	public String readPage(int bno, Criteria cri, RedirectAttributes rttr) {
		log.info("get readPage call!!! " + cri);
		service.updateViewCnt(bno);
		rttr.addAttribute("bno", bno);
		rttr.addAttribute("page", cri.getPage());
		rttr.addAttribute("perPageNum", cri.getPerPageNum());
		return "redirect:/board/readDetail";
	}
	
	@GetMapping("/readDetail")
	public String readDetail(int bno, @ModelAttribute("cri") Criteria cri, Model model) {
		log.info("get readDetail call!!!");
		model.addAttribute("board", service.readPage(bno));
		return "board/readPage";
	}
	
	@GetMapping("/modifyPage")
	public String modifyPage(int bno, Model model) {
		log.info("get modifyPage call!!!");
		model.addAttribute("board", service.readPage(bno));
		return "board/modify";
	}
	
	@PostMapping("/modifyPage")
	public String modifyPage(BoardVo board, @ModelAttribute("cri") Criteria cri, RedirectAttributes rttr) {
		log.info("post modifyPage call!!!");
		String msg = service.modify(board);
		rttr.addFlashAttribute("result", msg);
		rttr.addAttribute("page", cri.getPage());
		rttr.addAttribute("perPageNum", cri.getPerPageNum());
		return "redirect:/board/listPage";
	}
	
	@GetMapping("/remove")
	public String remove(int bno, @ModelAttribute("cri") Criteria cri, RedirectAttributes rttr) {
		log.info("get delete call!!!");
		String msg = service.remove(bno);
		rttr.addFlashAttribute("result", msg);
		rttr.addAttribute("page", cri.getPage());
		rttr.addAttribute("perPageNum", cri.getPerPageNum());
		return "redirect:/board/listPage";
	}

}
