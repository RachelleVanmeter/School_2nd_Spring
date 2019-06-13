package net.koreate.controller;

import java.util.List;

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
import net.koreate.vo.PageMaker;
import net.koreate.vo.SearchCriteria;

@Controller
@RequestMapping("/sboard/*")
@Slf4j
public class SearchController {
	
	@Inject
	BoardService service;
	
	@GetMapping("/list")
	public String list(SearchCriteria cri, Model model) {
		log.info("get list call!!! " + cri);
		List<BoardVo> list = service.searchList(cri);
		model.addAttribute("boardList", list);
		model.addAttribute("cri", cri);
		PageMaker pageMaker = service.getPageMaker(cri);
		model.addAttribute("pageMaker", pageMaker);
		return "sboard/listPage";
	}
	
	@GetMapping("/readPage")
	public String readPage(int bno, SearchCriteria cri, RedirectAttributes rttr) {
		log.info("get readPage call!!! " + cri);
		service.updateViewCnt(bno);
		rttr.addAttribute("bno", bno);
		rttr.addAttribute("page", cri.getPage());
		rttr.addAttribute("searchType", cri.getSearchType());
		rttr.addAttribute("keyword", cri.getKeyword());
		return "redirect:/sboard/readDetail";
	}
	
	@GetMapping("/register")
	public void register() {
		log.info("get register call!!!");
	}
	@PostMapping("/register")
	public String register(BoardVo board, RedirectAttributes rttr) {
		log.info("get readDetail call!!!");
		String msg = service.register(board);
		rttr.addFlashAttribute("result", msg);
		return "redirect:/sboard/list";
	}
	
	@GetMapping("/readDetail")
	public String readDetail(int bno, @ModelAttribute("cri") SearchCriteria cri, Model model) {
		log.info("get readDetail call!!!");
		model.addAttribute("board", service.read(bno));
		return "sboard/readPage";
	}
	
	@GetMapping("/modifyPage")
	public String modifyPage(int bno, @ModelAttribute("cri") SearchCriteria cri, Model model) {
		log.info("get modifyPage call!!!");
		model.addAttribute("board", service.read(bno));
		return "sboard/modify";
	}
	
	@PostMapping("/modifyPage")
	public String modifyPage(BoardVo board, SearchCriteria cri, RedirectAttributes rttr) {
		log.info("post modifyPage call!!!");
		String msg = service.modify(board);
		rttr.addFlashAttribute("result", msg);
		rttr.addAttribute("bno", board.getBno());
		rttr.addAttribute("page", cri.getPage());
		rttr.addAttribute("perPageNum", cri.getPerPageNum());
		rttr.addAttribute("searchType", cri.getSearchType());
		rttr.addAttribute("keyword", cri.getKeyword());
		return "redirect:/sboard/readDetail";
	}
	
	@PostMapping("/delete")
	public String delete(int bno, SearchCriteria cri, RedirectAttributes rttr) {
		log.info("post delete call!!!");
		String msg = service.remove(bno);
		rttr.addFlashAttribute("result", msg);
		rttr.addAttribute("page", cri.getPage());
		rttr.addAttribute("perPageNum", cri.getPerPageNum());
		rttr.addAttribute("searchType", cri.getSearchType());
		rttr.addAttribute("keyword", cri.getKeyword());
		return "redirect:/sboard/list";
	}
	
}
