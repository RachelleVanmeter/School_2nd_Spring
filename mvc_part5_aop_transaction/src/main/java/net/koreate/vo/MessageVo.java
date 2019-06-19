package net.koreate.vo;

import java.util.Date;

import lombok.Data;

@Data
public class MessageVo {
	private int mno;
	private String target;
	private String sender;
	private String message;
	private Date opendate;
	private Date senddate;
}
