package com.btone.web.home.domain.board.service;

import java.util.List;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import org.apache.commons.io.FileUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.btone.web.home.domain.board.dto.infoDTO;
import com.btone.web.home.domain.board.mapper.BoardMapper;
import com.btone.web.home.domain.board.vo.Board;
import com.btone.web.home.domain.board.vo.BoardFile;
import com.btone.web.home.domain.board.vo.BoardVO;
import com.btone.web.home.domain.board.vo.Category;

@Service
public class BoardService {
	@Autowired
	private BoardMapper boardMapper;

	@Autowired
	private static final Logger logger = LoggerFactory.getLogger(BoardService.class);

	@Autowired
	private FileService fileService;

	@Value("${file.upload-location}")
	String path;

	/**
	 * 글 등록 서비스
	 * 
	 * @author sojin
	 * @param board
	 * @return
	 * @throws Exception
	 */
	public int addContent(Board board) throws Exception {

		logger.debug("addContent Service 진입");
		// textarea에서 enter로 입력된 내용이 select할때는 공백으로 처리되어 나오기 때문에
		// html태그인 <br>로 바꿔서 DB에 저장.
		String row = (board.getBoardContent()).replace("\r\n", "<br>");
		board.setBoardContent(row);

		int result = boardMapper.addContent(board); // 일단 게시물 DB 저장
		logger.debug("boardNo : {}",board.getBoardNo());
			
		
		String uploadPath = new File("").getAbsolutePath()+"\\"+path;  //업로드될 폴더경로
		logger.debug("uploadPath >>>"+uploadPath);

		File folder = new File(uploadPath); // 미리 지정해놓은 경로에 파일 생성
		if (!folder.exists()) { // 디렉토리가 존재하지 않다면 하나 만들기
			try {
				folder.mkdir(); // 폴더 생성합니다. ("새폴더"만 생성)
				logger.debug("폴더가 생성완료.");
			} catch (Exception e) {
				e.getStackTrace();
			}
		} else {
			logger.debug("폴더가 이미 존재");
		}
		logger.debug("files : {} ", board.getFiles());
		

		for (MultipartFile f : board.getFiles()) { // 게시물에 포함된 파일 항목을 순회 
			if (!f.isEmpty()) {   //파일이 있다면 
				logger.info("file => {}", f.getOriginalFilename());

				// HDD에 저장
				String fileName = fileService.saveFile(f, uploadPath);  // 파일을 디렉토리에 업로드 

				// DB에 저장
				BoardFile boardFile = new BoardFile();   // DB에 저장하기 위한 객체 생성 

				boardFile.setBoardNo(board.getBoardNo());  // DB에 저장하면서 생긴 게시물의 번호 set
				boardFile.setFileOriginName(f.getOriginalFilename());  // 원래 파일이름 set
				boardFile.setFileSaveName(fileName);   // 디렉토리에 저장하면서 생긴 저장이름 set
				
				logger.debug("boardFile : {}", boardFile);
				boardMapper.addFile(boardFile);    // DB에 저장
			}
		}

		return result;
	}

	// 조회수
	public int updateHits(int bno) {
		logger.debug("조회수 증가 서비스 진입 : {}", bno);

		int row = boardMapper.updateHits(bno);

		return row;
	}

	public List<BoardVO> selectBoard(int cNo) {
		logger.debug("--------------셀렉트 보드 서비스 진입");

		logger.debug("mapper 타기 전 카테고리 넘버 : {}", cNo);

		List<BoardVO> selectBoard = boardMapper.selectBoard(cNo);

		logger.debug("셀렉트 보드 서비스 결과 : {}", selectBoard);

		return selectBoard;
	}

	// 글 상세보기
	public infoDTO getBoardInfo(int bno) {
		infoDTO info = boardMapper.getBoardInfo(bno);

		return info;

	}

	public byte[] download(String path) throws IOException {

		byte[] fileByte = null;
		try {
			fileByte = FileUtils.readFileToByteArray(new File(path));
		} catch (Exception e) {
			// throw new Exception("download error");
		}

		return fileByte;

	}

	public List<Category> categoryList() {

		return boardMapper.selectCategory();
	}

	public String updateContent(Board board) {
		String result = "";

		logger.debug("updateContent Service 진입");

		// textarea에서 enter로 입력된 내용이 select할때는 공백으로 처리되어 나오기 때문에
		// html태그인 <br>로 바꿔서 DB에 저장.
		String row = ((String) board.getBoardContent()).replace("\r\n", "<br>");
		board.setBoardContent(row);

		int val = boardMapper.updateContent(board);

		result = val > 0 ? "수정 되었습니다." : "수정 실패";

		return result;
	}

	public void deleteContent(int boardNo) {
		boardMapper.deleteContent(boardNo);

	}

}
