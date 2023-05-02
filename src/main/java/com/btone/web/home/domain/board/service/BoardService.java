package com.btone.web.home.domain.board.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.btone.web.home.domain.board.mapper.BoardMapper;
import com.btone.web.home.domain.board.vo.Board;

@Service
public class BoardService {
	@Autowired
	private BoardMapper boardMapper;
	@Autowired
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
}
