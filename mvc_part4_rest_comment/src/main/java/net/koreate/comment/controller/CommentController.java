package net.koreate.comment.controller;

import javax.inject.Inject;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import net.koreate.comment.service.CommentService;

@RestController
@RequestMapping("/comments")
public class CommentController {
	
	@Inject
	CommentService cs;
	
	

}








