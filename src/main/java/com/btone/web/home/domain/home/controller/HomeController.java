package com.btone.web.home.domain.home.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.btone.web.home.domain.board.vo.Board;
import com.btone.web.home.domain.board.vo.Category;
import com.btone.web.home.domain.home.service.HomeService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
	
	@Autowired
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	@Autowired
	private HomeService homeService;
	
	@GetMapping("/")
	public String ShowFirst(HttpServletRequest request, HttpServletResponse response, ModelMap model) {
		logger.debug("------------------- homecotroller 진입");		
		List<Board> list = homeService.getList();
		model.addAttribute("list", list);
		
		List<Category> cateList = homeService.getCate();
		model.addAttribute("cate", cateList);
		
		
		logger.debug("list: {}", list);
				
		logger.debug("컨트롤러 카테고리 리스트: {}", cateList);
		return "home";
	}
	
	@GetMapping("/join")
	public String ShowRegist(HttpServletRequest request, HttpServletResponse response, ModelMap model) {
		logger.debug("------------------- homecotroller 진입");		
					
		List<Category> cateList = homeService.getCate();
		model.addAttribute("cate", cateList);
		
		return "join";
	}
	
	@GetMapping("/login")
	public String ShowLogin(HttpServletRequest request, HttpServletResponse response, ModelMap model) {
		logger.debug("------------------- homecotroller 진입");		
			
		List<Category> cateList = homeService.getCate();
		model.addAttribute("cate", cateList);
		
		return "login";
	}	
	
	@GetMapping("/write/{userNo}")
	public String ShowServices(HttpServletRequest request, HttpServletResponse response, ModelMap model) {
		logger.debug("------------------- write page 진입");		
		
		List<Category> cateList = homeService.getCate();
		model.addAttribute("cate", cateList);
		
		return "writeContents";
	}
	
	@GetMapping("/contents")
	public String ShowContents(HttpServletRequest request, HttpServletResponse response, ModelMap model) {
		logger.debug("------------------- homecotroller 진입");		
						
		List<Category> cateList = homeService.getCate();
		model.addAttribute("cate", cateList);
		
		return "contents";
	}
	
	
}
