package com.btone.web.home.domain.home.controller;

import java.io.File;
import java.io.IOException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.FileUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.btone.web.home.domain.board.service.BoardService;
import com.btone.web.home.domain.board.vo.Board;
import com.btone.web.home.domain.home.service.HomeService;

@RestController
@RequestMapping("/")
public class HomeRestController {

	private static final Logger logger = LoggerFactory.getLogger(HomeRestController.class);
	
	@Autowired
	private HomeService homeService;
	
	@RequestMapping("getSearch")
	 public List<Board> Showsearch(@RequestParam ("search") String search, @RequestParam("type") String type, 
			HttpServletRequest request, HttpServletResponse response) throws Exception { //배열에 담긴 값을 뽑아줘야함.
		
		logger.debug("{}" ,"검색창 진입");
		
		List<Board> searchList;
		if(search.length() > 0) { //검색이 있다면
			searchList = homeService.getSearch(search, type);
			logger.debug("list : {}" ,searchList);
		}else {
			searchList = homeService.getList();
			logger.debug("list : {}" ,searchList);
		}
		
		return searchList;
	}


}
