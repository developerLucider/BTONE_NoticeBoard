package com.btone.web.home.domain.board.controller;

import java.io.File;
import java.io.IOException;
import java.net.URLEncoder;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.btone.web.home.domain.board.service.CommentService;
import org.apache.commons.io.FileUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import com.btone.web.home.domain.board.dto.infoDTO;
import com.btone.web.home.domain.board.service.BoardService;
import com.btone.web.home.domain.board.vo.Board;
import com.btone.web.home.domain.board.vo.Category;
import com.btone.web.home.domain.home.service.HomeService;

@Controller
@RequestMapping("/board")
public class BoardController {

	private static final Logger logger = LoggerFactory.getLogger(BoardController.class);
	
	@Autowired
	private BoardService boardService;

	@Autowired
	private CommentService commentService;
	
	@Value("${file.upload-location}")
	String fileConfigPath;
	/**
	 * 글 등록
	 * @author sojin
	 * @param board
	 * @return int (해당게시글의 번호PK)
	 * @throws Exception
	 */
	@Autowired
	private HomeService homeService;
	
	@ResponseBody
	@PostMapping(value="/addContent.do")
	public int addContent (Board board) throws Exception{
		logger.debug("addContent 진입");
		logger.debug("board : {}", board);	
				
		return boardService.addContent(board);
		
	}

   //글상세보기
	@GetMapping(value="/{bno}")	
	public String Showinfo(@PathVariable int bno, HttpServletRequest request, HttpServletResponse response, ModelMap model) {
		logger.debug("------------------- info 진입");		

		infoDTO info = boardService.getBoardInfo(bno);

		model.addAttribute("info", info);

		logger.debug("내가 클릭한 글 번호 : {}", bno);
		boardService.updateHits(bno);


		logger.debug(" {} :", bno);
		logger.debug("info {} :", info);
		
		
		List<Category> cateList = homeService.getCate();
		model.addAttribute("cate", cateList);
		
		return "info";
	}
	
	/**
	 * 글 수정페이지 연결
	 * @author sojin
	 * @param boardNo
	 * @param model
	 * @return 수정페이지경로
	 * @throws Exception
	 */
	@GetMapping(value="/update/{boardNo}")
	public String updateForm(@PathVariable int boardNo, Model model)throws Exception{
		logger.debug("updateForm 진입");
		logger.debug("boardNo:{}", boardNo);
		
		infoDTO info = boardService.getBoardInfo(boardNo);   //게시글 정보
		List<Category> list = boardService.categoryList();   //전체 카테고리 리스트 

		model.addAttribute("board", info);
		model.addAttribute("cate", list);		
		
		logger.debug("board :{}", info);

		
		logger.debug("board :{}", info);

		return "updateForm";		
	}
	
	/**
	 * 글 수정 
	 * @author sojin
	 * @param board
	 * @return
	 * @throws Exception
	 */
	@ResponseBody
	@PostMapping(value="/updateContent.do")
	public String updateContent(@RequestBody Board board) throws Exception{
		logger.debug("updateContent 진입");
		logger.debug("board : {}", board);
		return boardService.updateContent(board);
	}
	/**
	 * 글 삭제
	 * @author sojin
	 * @param boardNo
	 * @throws Exception
	 */
	@ResponseBody
	@RequestMapping(value="/deleteContent.do")
	public void deleteContent(@RequestParam("boardNo") int boardNo) throws Exception{
		logger.debug("deleteContent 진입");
		logger.debug("boardNo : {}", boardNo);
		boardService.deleteContent(boardNo);
	}	
	
	
	/**
	 * @author sojin
	 * @param files
	 * @param model
	 * @return map
	 * @throws IOException
	 * 파일 업로드
	 */
		

	// 파일의 경로를 찾아서 떨구는 기능
	@GetMapping(value="/upload/fileDownload.do")
	public void downloadAttach(@RequestParam("filePath") String fileinfo, @RequestParam("fileName") String fileName,
			HttpServletResponse response) throws IOException {

		String uploadPath = new File("").getAbsolutePath() + "\\" + fileConfigPath;
		String path = uploadPath + fileinfo;
		try {
			byte[] fileByte = FileUtils.readFileToByteArray(new File(path));

			response.setContentType("application/octet-stream");
			response.setHeader("Content-Disposition",
					"attachment; fileName=\"" + URLEncoder.encode(fileName, "UTF-8") + "\";");
			response.setHeader("Content-Transfer-Encoding", "binary");

			response.getOutputStream().write(fileByte);
			response.getOutputStream().flush();
			response.getOutputStream().close();

		} catch (IOException ex) {

		}
	}

}
