package net.koreate.comment.service;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import net.koreate.comment.dao.CommentDAO;

@Service
public class CommentServiceImpl implements CommentService{
	
	@Inject
	CommentDAO dao;
	
	
}
