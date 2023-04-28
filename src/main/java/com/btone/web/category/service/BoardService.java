
package com.btone.web.category.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.btone.web.board.mapper.BoardMapper;
import com.btone.web.board.vo.BoardVO;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@RequiredArgsConstructor
@Slf4j
@Service
public class BoardService {

	private static final Logger logger = LoggerFactory.getLogger(BoardService.class);
	
	private final BoardMapper boardMapper;
	
	public int addBoard(BoardVO boardVO) {
		logger.debug("-------------------addBoard Service 진입");
		
		int row = boardMapper.addBoard(boardVO);
		
		
		logger.debug("addBoard 결과는 ? : {}", row);
		
		
		return row;
	}	
}
