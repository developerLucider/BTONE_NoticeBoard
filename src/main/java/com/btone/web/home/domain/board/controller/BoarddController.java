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
import com.btone.web.home.domain.board.vo.Category;
import com.btone.web.home.domain.home.service.HomeService;
import com.common.Utils;

@Controller

public class BoarddController {

	private static final Logger logger = LoggerFactory.getLogger(BoarddController.class);
	
	@Autowired
	private BoardService boardService;

	@Autowired
	private HomeService homeService;	
	
	
	@GetMapping("/boardCate/{cNo}")
	public String selectBoard(ModelMap model, @PathVariable int cNo, HttpServletRequest request, HttpServletResponse response)throws Exception{
		//
		logger.debug("-------------------셀렉트 보드 컨트롤러 진입");
		
		logger.debug("카테고리 넘버 :  {}", cNo);
		
		List<BoardVO> selectBoard = boardService.selectBoard(cNo);
		
		//유저리스트 '만' 뽑고 싶다.
		List<BoardVO> selectUserList = boardService.selectBoard(cNo);
		
		logger.debug("셀렉트 보드 리스트 :  {}", selectBoard);
		
		model.addAttribute("list", selectBoard);
		
		model.addAttribute("cName", selectBoard.get(cNo).getCName());
		
		model.addAttribute("maskName", Utils.NameMasking(selectUserList.get(cNo).getUserName()));
		
		
		//이름만 빼서 새로운 List에 담는 것은 나중에 하도록 하겠습니다.
		logger.debug("제발 나와라!~~~~~ : {}", selectUserList);
		
		
		List<Category> cateList = homeService.getCate();
		model.addAttribute("cate", cateList);
		
		logger.debug("셀렉트 보드 컨트롤러 결과 : {}", selectBoard);
			
			
			return "boardCate";  
		}
	}

	
