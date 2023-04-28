package com.btone.web.board.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;

import com.btone.web.board.service.BoardService;
import com.btone.web.board.vo.BoardVO;

@Controller
public class BoardController {
	
	@Autowired
	private static final Logger logger = LoggerFactory.getLogger(BoardController.class);
	
	@Autowired
	private BoardService boardService;
	
	//글 등록 액션
	@GetMapping("/addBoard")
	public String addBoard(BoardVO boardVO, ModelMap model, HttpServletRequest request) {
		logger.debug("------------------- addBoard Action Controller 진입");		
		
		logger.debug("글 등록 확인 : {}", boardVO);
		
		boardService.addBoard(boardVO);
				
		return "/writeContents";
	}
	
	
	
	
	
}
