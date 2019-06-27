package net.koreate.controller;

import java.util.Map;

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

import net.koreate.service.CommentService;
import net.koreate.vo.CommentVO;

@RestController
@RequestMapping("/comments")
public class CommentController {

	@Inject
	CommentService cs;

	@PostMapping("/add")
	public ResponseEntity<String> addComment(@RequestBody CommentVO vo) {
		System.out.println("comment add : " + vo);
		ResponseEntity<String> entity = null;
		try {
			cs.addComment(vo);
			entity = new ResponseEntity<String>("SUCCESS", HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			entity = new ResponseEntity<String>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}
		return entity;
	}

	@GetMapping("/{bno}/{page}")
	public ResponseEntity<Map<String, Object>> listPage(@PathVariable("bno") int bno, @PathVariable("page") int page) {
		ResponseEntity<Map<String, Object>> entity = null;
		// 보여줄 댓글 리스트 & pageMaker
		try {
			Map<String, Object> map = cs.listPage(bno, page);
			entity = new ResponseEntity<Map<String, Object>>(map, HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			entity = new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		return entity;
	}

	// 덧슬 수정
	// /comments/cno
	@PatchMapping("/{cno}")
	public ResponseEntity<String> updata(@PathVariable("cno") int cno, @RequestBody CommentVO vo) {
		System.out.println("comment add : " + vo);
		ResponseEntity<String> entity = null;
		try {
			cs.addComment(vo);
			entity = new ResponseEntity<String>("SUCCESS", HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			entity = new ResponseEntity<String>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}
		return entity;
	}
}
