package com.btone.web.home.domain.login.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.btone.web.home.domain.login.service.LoginService;
import com.btone.web.home.domain.login.vo.UserLoginVO;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RequestMapping(value = "/login")
@RestController
public class LoginRestController {

	private static final Logger logger = LoggerFactory.getLogger(LoginRestController.class);
	
	private final LoginService loginService;
		
	//로그인 (세션에 로그인 유저정보 담기)
	@RequestMapping("/login.do")
	public UserLoginVO userLogin(@RequestBody UserLoginVO userLoginVo, HttpServletRequest request, Model model){
		
		logger.info("----- 로그인 컨트롤러 진입 -----");
		
		// 요청에 대한 세션의 정보를 가져온다. (로그인 여부에 대한 정보를 담기위해)
		HttpSession httpSession = request.getSession();
				
		// 로그인 검증(db에 계정정보가있는지 체크)
	 	UserLoginVO loginUser = loginService.loginUser(userLoginVo);
	    
 		
 		if( loginUser != null) { // 로그인 검증에 성공 시 	 		    
 	 		logger.debug("로그인유저정보 : {}", loginUser);	
 	 		httpSession.setAttribute("loginUser", loginUser); // 세션에 loginuser정보 attribute를 담음
 	 		return loginUser;		// 로그인 유저의 정보를 반환
 			
 		} else {	// 로그인 실패 시  				    
 		    return null;			// null을 반환
 		}
	}
	
	// 로그아웃 (세션의 유저정보 삭제)
	@RequestMapping("/logout.do")
	public void logout(HttpSession httpSession, HttpServletResponse response) throws IOException {
		httpSession.invalidate();
		
		response.sendRedirect("/");
	}
	
}
