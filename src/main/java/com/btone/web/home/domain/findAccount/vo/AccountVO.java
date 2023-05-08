package com.btone.web.home.domain.findAccount.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Setter
@Getter
public class AccountVO {
	private int userNo;
	private String userEmail;
	private String userName;
	private String userId;
	private String userPassword;
}