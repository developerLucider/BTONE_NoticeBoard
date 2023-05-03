package com.btone.web.home.domain.board.controller;

<<<<<<< Updated upstream
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

=======
>>>>>>> Stashed changes
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
<<<<<<< Updated upstream
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
=======
>>>>>>> Stashed changes
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.btone.web.home.domain.board.service.BoardService;
import com.btone.web.home.domain.board.vo.Board;

@Controller
@RequestMapping("/")
public class BoardController {

	private static final Logger logger = LoggerFactory.getLogger(BoardController.class);
	
	@Autowired
	private BoardService boardService;

	@ResponseBody
	@RequestMapping(value="/addContent.do")
	public String addContent (@RequestBody Board board) throws Exception{
		logger.debug("addContent 진입");
		return boardService.addContent(board);
		
	}
<<<<<<< Updated upstream
=======
}
>>>>>>> Stashed changes

//	글상세보기
	@GetMapping("info/{bno}")
	public String Showinfo(@PathVariable int bno, HttpServletRequest request, HttpServletResponse response, ModelMap model) {
		logger.debug("------------------- info 진입");		
		Board info = boardService.getBoardInfo(bno);
		model.addAttribute("info", info);
		
		logger.debug(" {} :", bno);
		
		return "info";
	}
	
}
