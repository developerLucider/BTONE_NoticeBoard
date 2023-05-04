
package com.btone.web.home.domain.findAccount.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.btone.web.home.domain.login.mapper.LoginMapper;
import com.btone.web.home.domain.login.vo.UserLoginVO;
import com.common.Base64Utils;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@RequiredArgsConstructor
@Slf4j
@Service
public class FindAccountService {

	private static final Logger logger = LoggerFactory.getLogger(FindAccountService.class);
	
	private final LoginMapper loginMapper;
	  
	public UserLoginVO loginUser(UserLoginVO userLoginVo) {
		
		logger.debug("로그인 서비스 진입");
				
	 	// 통신을 통해 받은 로그인정보
	 	String tryId = userLoginVo.getUserId();
	    String tryPw = userLoginVo.getUserPassword();
	    	    
	    
	    logger.debug("----- 접속시도 계정 ID : {}", tryId);
	    logger.debug("----- 접속시도 계정 비밀번호 : {}", tryPw);
	    
	    // 로그인할 계정의 정보가 db에 있는지 확인
	 	UserLoginVO loginUser = loginMapper.loginUser(userLoginVo);
	 		    	
    	String dbId = loginUser.getUserId();
    	String dbPw = loginUser.getUserPassword();

    	logger.debug("---- db 저장 아이디{}", dbId);
    	logger.debug("---- db 저장 비밀번호{}", dbPw);

      
    	// common으로 만든 디코더를 이용해 복호화
    	String decodingPw = Base64Utils.base64Decoder(dbPw);
    	
    	logger.debug("디코딩된 비밀번호 : {}", decodingPw);
	  
	    
    	if(tryId.equals(dbId) && tryPw.equals(decodingPw)) {		    	
    		return loginUser;
    	}  else {
    		return null;
    	}  
	}
	
}
