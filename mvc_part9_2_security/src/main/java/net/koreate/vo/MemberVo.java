package net.koreate.vo;

import java.util.Date;
import java.util.List;

import lombok.Data;

@Data
public class MemberVo {
	private String uid;
	private String upw;
	private String uname;
	private Date regdate;
	private Date updatedate;
	private List<AuthVo> authList;
}
