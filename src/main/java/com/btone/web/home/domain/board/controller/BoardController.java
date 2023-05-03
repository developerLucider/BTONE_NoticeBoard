package com.btone.web.home.domain.board.controller;

<<<<<<< HEAD
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

=======
import java.io.File;
import java.io.IOException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.FileUtils;
>>>>>>> feature/sojin
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
<<<<<<< HEAD
import org.springframework.web.bind.annotation.PathVariable;
=======
import org.springframework.web.bind.annotation.PostMapping;
>>>>>>> feature/sojin
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

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


//	글상세보기
	@GetMapping("info/{bno}")
	public String Showinfo(@PathVariable int bno, HttpServletRequest request, HttpServletResponse response, ModelMap model) {
		logger.debug("------------------- info 진입");		
		Board info = boardService.getBoardInfo(bno);
		model.addAttribute("info", info);
		
		logger.debug(" {} :", bno);
		
		return "info";
	}
	

	
	/**
	 * @author sojin
	 * @param files
	 * @param model
	 * @return map
	 * @throws IOException
	 * 파일 업로드
	 */
	@Value("${file.upload-location}")
	String fileConfigPath;
	
	@ResponseBody
	@PostMapping("/upload/fileUpload.do")
	public Map fileUpload(@RequestParam(value = "uploadFiles", required = false) List<MultipartFile> files, ModelMap model)
			throws IOException {
		
		logger.debug("files", files);
		
		List<Map> resultListMap = new ArrayList<Map>();
		if (files != null) { // 다건처리
			for (MultipartFile multipartFile : files) {
				Map fileMap = new HashMap();
				fileMap = boardService.saveFile(multipartFile);

				if (!fileMap.isEmpty())
					resultListMap.add(fileMap);
			}
		}	

		Map resultMap = new HashMap();

		resultMap.put("list", resultListMap);

		return resultMap;
	}

	// 파일의 경로를 찾아서 떨구는 기능
	@GetMapping("/upload/fileDownload.do")
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
