package com.btone.web.home.domain.regist.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.btone.web.home.domain.regist.service.RegistService;
import com.btone.web.home.domain.regist.vo.UserVO;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RequestMapping(value = "/regist")
@RestController
public class RegistRestController {

	private static final Logger logger = LoggerFactory.getLogger(RegistRestController.class);
	
	private final RegistService registService;
		
	//아이디 중복체크하기
	@RequestMapping("/idChk.do")
	public Boolean idChk(@RequestParam("userId") String userId) {
		logger.debug("----- 아이디 중복체크 -----");
		Boolean result = registService.idChk(userId);
				
		return result;
	}
	
	// 회원가입
	@RequestMapping(value="/join.do")
	public int join(@RequestBody UserVO user, HttpServletRequest request, HttpServletResponse response) throws Exception {

		logger.debug("{}" ,"회원가입 진입");
		int res = registService.join(user);
		
		return res;
	}
	
}
