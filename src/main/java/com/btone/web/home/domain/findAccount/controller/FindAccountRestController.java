package com.btone.web.home.domain.findAccount.controller;

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
@RequestMapping(value = "/login/find")
@RestController
public class FindAccountRestController {

	private static final Logger logger = LoggerFactory.getLogger(FindAccountRestController.class);
	
	private final FindAccountService findAccountService;
		
	//로그인 (세션에 로그인 유저정보 담기)
	@RequestMapping("/findId.do")
	public AccountVO userLogin(@RequestBody AccountVO accountVo, HttpServletRequest request, Model model){
		
		logger.info("----- ID 찾기 컨트롤러 진입 -----");
						
		// 아이디 찾기
		AccountVO findId = findAccountService.findId(accountVo);
	     		 		    
 		logger.debug("------ 찾아온 ID : {}", findId);	
 		
 		return findId;
	}
	
	
	
}
