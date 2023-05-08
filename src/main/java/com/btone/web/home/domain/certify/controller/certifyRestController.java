package com.btone.web.home.domain.certify.controller;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.btone.web.home.domain.findAccount.service.FindAccountService;
import com.btone.web.home.domain.findAccount.vo.AccountVO;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RequestMapping(value = "/certify")
@RestController
public class certifyRestController {

	private static final Logger logger = LoggerFactory.getLogger(certifyRestController.class);
	
	private final FindAccountService findAccountService;
		
	//ID 찾기
	@RequestMapping("/Email.do")
	public AccountVO findId(@RequestBody AccountVO accountVo, HttpServletRequest request, Model model){
		
		logger.info("----- 이메일 인증 컨트롤러 진입 -----");
						
		
 		return null;
	}	
	
	
}
