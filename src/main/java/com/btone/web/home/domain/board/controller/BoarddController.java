package com.btone.web.home.domain.board.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.btone.web.home.domain.board.service.BoardService;
import com.btone.web.home.domain.board.vo.BoardVO;

@Controller

public class BoarddController {

	private static final Logger logger = LoggerFactory.getLogger(BoarddController.class);
	
	@Autowired
	private BoardService boardService;

	
	@GetMapping("/boardCate/{cNo}")
	public String selectBoard(ModelMap model, @PathVariable int cNo, HttpServletRequest request, HttpServletResponse response)throws Exception{
		//
		logger.debug("-------------------셀렉트 보드 컨트롤러 진입");
		
		logger.debug("카테고리 넘버 :  {}", cNo);
		
		List<BoardVO> selectBoard = boardService.selectBoard(cNo);
		
		logger.debug("셀렉트 보드 리스트 :  {}", selectBoard);
		
		model.addAttribute("list", selectBoard);
		
		model.addAttribute("cName", selectBoard.get(cNo).getCName());
		
		logger.debug("셀렉트 보드 컨트롤러 결과 : {}", selectBoard);
			
			
			return "boardCate";  
		}
	}

	
