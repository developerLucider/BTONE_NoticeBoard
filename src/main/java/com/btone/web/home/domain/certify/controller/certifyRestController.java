package com.btone.web.home.domain.certify.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.btone.web.home.domain.certify.service.CertifyService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RequestMapping(value = "/certify")
@RestController
public class certifyRestController {

	private static final Logger logger = LoggerFactory.getLogger(certifyRestController.class);
	
	private final CertifyService certifyService;
		
	//이메일 인증번호 전송
	@RequestMapping("/Email.do")
	public int sendCertNo(@RequestParam("userEmail") String userEmail, HttpServletRequest request, Model model){
		
		logger.info("----- 이메일 인증 컨트롤러 진입 -----");
		
		HttpSession session = request.getSession();
		
		int res = certifyService.sendCertNo(session, userEmail);
		
 		return res;
 	}	
}
