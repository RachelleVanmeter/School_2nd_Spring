package net.koreate.vo;

import java.util.Date;

import lombok.Data;

@Data
public class CommentVo {
	private int cno;
	private int bno;
	private String commentText;
	private String commentAuth;
	private Date regdate;
	private Date updatedate;

	private int uno;
}
