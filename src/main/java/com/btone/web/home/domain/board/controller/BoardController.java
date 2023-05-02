package com.btone.web.home.domain.board.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.btone.web.home.domain.board.service.BoardService;
import com.btone.web.home.domain.board.vo.Board;


@Controller
@RequestMapping("/board")
public class BoardController {
	@Autowired
	private static final Logger logger = LoggerFactory.getLogger(BoardController.class);
	
	@Autowired
	private BoardService boardService;

	@ResponseBody
	@RequestMapping(value="/addContent.do")
	public String addContent (@RequestBody Board board) throws Exception{
		logger.debug("addContent 진입");
		return boardService.addContent(board);
		
	}
}
