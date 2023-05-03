package com.btone.web.home.domain.board.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.btone.web.home.domain.board.mapper.BoardMapper;
import com.btone.web.home.domain.board.vo.Board;
import com.btone.web.home.domain.board.vo.BoardVO;

@Service
public class BoardService {
	@Autowired
	private BoardMapper boardMapper;
	
	private static final Logger logger = LoggerFactory.getLogger(BoardService.class);

	public String addContent(Board board) {
		
		logger.debug("addContent Service 진입");
		String result = "";
		
		int mapper = boardMapper.addContent(board);
		if(mapper >0) {
			result = "글이 등록되었습니다.";
		}else {
			result = "등록에 실패했습니다.";
		}
	
		return result;
	}
	public List<BoardVO> selectBoard(){
		logger.debug("--------------셀렉트 보드 서비스 진입");
		
		List<BoardVO> selectBoard = boardMapper.selectBoard();
		
		logger.debug("셀렉트 보드 서비스 결과 : {}", selectBoard);
		
		return selectBoard;
	}
}