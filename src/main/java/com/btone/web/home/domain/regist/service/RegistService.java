
package com.btone.web.home.domain.regist.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.btone.web.home.domain.regist.mapper.RegistMapper;
import com.btone.web.home.domain.regist.vo.UserVO;
import com.common.Base64Utils;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@RequiredArgsConstructor
@Slf4j
@Service
public class RegistService {

	private static final Logger logger = LoggerFactory.getLogger(RegistService.class);
	
	private final RegistMapper registMapper;
	  
	public Boolean idChk(String userId) {
		logger.debug("----- RegistService idchk 진입 -----");
		logger.debug("check하는 ID = {}", userId);
		int result = registMapper.idChk(userId);
		
		if(result == 0) {	return true;	}
		else {	return false;	}
	}
	
	public int join(UserVO user) {		
		logger.debug("암호화 전 user정보 : {}", user);
		
		if (idChk(user.getUserId())) { // id중복여부 확인 후

			String pass = user.getUserPassword(); 			
			String pwd = Base64Utils.base64Encoder(pass);	// 암호화 비밀번호 생성
						
			user.setUserPassword(pwd);		// vo에 암호화한 비밀번호를 넣은뒤 계정 정보 db로
			
			logger.debug("암호화 후 user정보 : {}", user);
		}	
		
		return registMapper.join(user);
	}
}
