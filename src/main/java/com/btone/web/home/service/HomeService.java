
package com.btone.web.home.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.btone.web.home.mapper.TestMapper;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@RequiredArgsConstructor
@Slf4j
@Service
public class HomeService {

	private static final Logger logger = LoggerFactory.getLogger(HomeService.class);
	
	private final TestMapper testMapper;
	
	public String getTestString() {
		logger.debug("-------------------homeService 진입");
		
		String res = testMapper.getTestString();
		
		logger.debug("test 테이블의 testCol 칼럼 : {}", res);
		
		return res;
	}	
}
