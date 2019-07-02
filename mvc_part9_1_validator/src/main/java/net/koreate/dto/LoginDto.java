package net.koreate.dto;

import lombok.Data;

@Data
public class LoginDto {
	private String u_id;
	private String u_pw;
	private String rememberme;
}
