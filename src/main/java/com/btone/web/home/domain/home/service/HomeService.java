
package com.btone.web.home.domain.home.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.btone.web.home.domain.board.vo.Board;
import com.btone.web.home.domain.board.vo.BoardVO;
import com.btone.web.home.domain.home.mapper.HomeMapper;
import com.btone.web.home.domain.test.TestMapper;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@RequiredArgsConstructor
@Slf4j
@Service
public class HomeService {

	private static final Logger logger = LoggerFactory.getLogger(HomeService.class);
	
	private final HomeMapper homeMapper;
	
	public List<Board> getList() {
		logger.debug("-------------------homeService 진입");
		
		List<Board> list = homeMapper.getList();
		
		logger.debug(" List : {}", list);
		
		return list;
	}

	//검색
	public List<Board> getSearch(String search, String type) {
		logger.debug("-------------------homeService 진입");
		List<Board> searchList = homeMapper.getSearch(search, type);
		
		return searchList;
	}
	
	


}
