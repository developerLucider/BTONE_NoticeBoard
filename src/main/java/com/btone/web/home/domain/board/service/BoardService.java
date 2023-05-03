package com.btone.web.home.domain.board.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.btone.web.home.domain.board.mapper.BoardMapper;
import com.btone.web.home.domain.board.vo.BoardVO;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor

public class BoardService {
	
	private static final Logger logger = LoggerFactory.getLogger(BoardService.class);
	
	private final BoardMapper boardMapper;
	
	
	public List<BoardVO> selectBoard(){
		logger.debug("--------------셀렉트 보드 서비스 진입");
		
		List<BoardVO> selectBoard = boardMapper.selectBoard();
		
		logger.debug("셀렉트 보드 서비스 결과 : {}", selectBoard);
		
		return selectBoard;
	}
	
	
}
