
package com.btone.web.home.domain.findAccount.service;

import java.util.Objects;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.btone.web.home.domain.findAccount.mapper.FindAccountMapper;
import com.btone.web.home.domain.findAccount.vo.AccountVO;
import com.common.Base64Utils;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@RequiredArgsConstructor
@Slf4j
@Service
public class FindAccountService {

	private static final Logger logger = LoggerFactory.getLogger(FindAccountService.class);
	
	private final FindAccountMapper findAccountMapper;
	  
	public AccountVO findId(AccountVO accountVo) {
		
		logger.debug("ID찾기 서비스 진입");
			    
	    logger.debug("----- 찾으려는 계정의 이름 : {}", accountVo.getUserName());
	    logger.debug("----- 찾으려는 계정의 이메일 : {}", accountVo.getUserEmail());
	    
	    // 로그인할 계정의 정보가 db에 있는지 확인
	 	AccountVO findUser = findAccountMapper.findId(accountVo);
	 	if(Objects.isNull(findUser)) {
	 		// null exception 방지 빈 객체 생성
	 		findUser = new AccountVO();
	 		findUser.setUserId("");
	 	}
	 	
    	String findId = findUser.getUserId();

    	logger.debug("---- db에서 검색한 아이디 : {}", findId);

    	return findUser;		 
	}
	
	public AccountVO findPw(AccountVO accountVo) {
		
		logger.debug("PW찾기 서비스 진입");
		
		logger.debug("----- 찾으려는 계정의 ID : {}", accountVo.getUserId());
	    logger.debug("----- 찾으려는 계정의 이름 : {}", accountVo.getUserName());
	    logger.debug("----- 찾으려는 계정의 이메일 : {}", accountVo.getUserEmail());
	    
	    // 로그인할 계정의 정보가 db에 있는지 확인
	 	AccountVO findUser = findAccountMapper.findPw(accountVo);
	 	
	 	if(Objects.isNull(findUser)) {
	 		// null exception 방지 빈 객체 생성 후 빈값 넣기
	 		findUser = new AccountVO();
	 		findUser.setUserId("");
	 		findUser.setUserPassword("");
	 		
	 		return findUser;
	 	} else {
	 		// common으로 만든 디코더를 이용해 복호화
	 		String decodingFindPw =	Base64Utils.base64Decoder(findUser.getUserPassword());
			  
			logger.debug("----- 디코딩된 찾을 계정의 비밀번호 : {}", decodingFindPw);
			
			// 복호화한 비밀번호를 객체에 담아 리턴
			findUser.setUserPassword(decodingFindPw);
			
			return findUser; 
	 	}	 			
			   
	}
}
