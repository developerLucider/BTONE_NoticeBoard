package com.btone.web.home.domain.board.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.btone.web.home.domain.board.service.BoardService;
import com.btone.web.home.domain.board.vo.BoardVO;

@Controller
@RequestMapping("/")
public class BoarddController {

	private static final Logger logger = LoggerFactory.getLogger(BoarddController.class);
	
	@Autowired
	private BoardService boardService;

	
	@GetMapping("boardOne")
	public String selectBoard(ModelMap model)throws Exception{
		//
		logger.debug("-------------------셀렉트 보드 컨트롤러 진입");
		
		List<BoardVO> selectBoard = boardService.selectBoard();
		
		logger.debug("셀렉트 보드 리스트 :  {}", selectBoard);
		
		model.addAttribute("list", selectBoard);
		
		logger.debug("셀렉트 보드 컨트롤러 결과 : {}", selectBoard);
			
			
			return "boardOne";  
		}
	}

	
