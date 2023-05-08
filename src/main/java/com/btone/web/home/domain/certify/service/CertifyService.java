
package com.btone.web.home.domain.certify.service;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.btone.web.home.domain.certify.mapper.CertifyMapper;
import com.btone.web.home.domain.findAccount.vo.AccountVO;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@RequiredArgsConstructor
@Slf4j
@Service
public class CertifyService {

	private static final Logger logger = LoggerFactory.getLogger(CertifyService.class);
	
	private final CertifyMapper certifyMapper;
	  
	public int sendCertNo(HttpSession session, String userEmail) {
		
		logger.debug("ID찾기 서비스 진입");
			    
	    return 0;
	}	
}
