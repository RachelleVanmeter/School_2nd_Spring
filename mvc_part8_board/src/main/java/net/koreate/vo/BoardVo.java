package net.koreate.vo;

import java.util.Date;

import lombok.Data;

@Data
public class BoardVo {
	private int bno;
	private String title;
	private String content;
	private String writer;
	private int origin;
	private int depth;
	private int seq;
	private Date regdate;
	private Date updatedate;
	private int viewcnt;
	private String showboard;
	private int uno;

	private String[] files;
	private int commentCnt;
}
