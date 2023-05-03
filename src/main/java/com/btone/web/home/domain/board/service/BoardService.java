package com.btone.web.home.domain.board.service;

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

import com.btone.web.home.domain.board.mapper.BoardMapper;
import com.btone.web.home.domain.board.vo.Board;

@Service
public class BoardService {
	@Autowired
	private BoardMapper boardMapper;
	@Autowired
	private static final Logger log = LoggerFactory.getLogger(BoardService.class);
	
	@Value("${file.upload-location}")
    String fileConfigPath;

	public String addContent(Board board) {
		
		log.debug("addContent Service 진입");
		String result = "";
		
		int mapper = boardMapper.addContent(board);
		if(mapper >0) {
			result = "글이 등록되었습니다.";
		}else {
			result = "등록에 실패했습니다.";
		}
	
		return result;
	}

	public Map saveFile(MultipartFile multipartFile) throws IOException{
		

        if (multipartFile.isEmpty()) {
            return null;
        }

        String savedFileName = "";
        // 1. 파일 저장 경로 설정 : 실제 서비스되는 위치(프로젝트 외부에 저장)
        //  String uploadPath = fileConfigPath;  //현재는 절위의 yml에 지정 한 경로로 사용시 필요

        String uploadPath = new File("").getAbsolutePath() + "\\"+fileConfigPath;  //absolutePath
        log.debug("uploadPath >>>"+uploadPath);
        File Folder = new File(uploadPath);

    	// 해당 디렉토리가 없다면 디렉토리를 생성.
		if (!Folder.exists()) {
			try {
				Folder.mkdir(); // 폴더 생성합니다. ("새폴더"만 생성)
				log.debug("폴더가 생성완료.");
			} catch (Exception e) {
				e.getStackTrace();
			}
		} else {
			log.debug("폴더가 이미 존재");
		}
        // 2. 원본 파일 이름 알아오기
        String originalFileName = multipartFile.getOriginalFilename();
       // file.get
        log.debug("originalFileName     >>  "+originalFileName);
        // 3. 파일 이름 중복되지 않게 이름 변경(서버에 저장할 이름) UUID 사용  //해당정보로 insert 처리 후 파일 목록 조회 가능
        UUID uuid = UUID.randomUUID();
        savedFileName = uuid.toString()+"_"+ originalFileName;
        log.debug("savedFileName     >>  "+savedFileName);

        //mapper적용해서 db저장하기

        // 4. 파일 생성
        File file1 = new File(uploadPath + savedFileName);
        // 5. 서버로 전송
        multipartFile.transferTo(file1);
        Map resultMap = new HashMap();
        resultMap.put("originalFileName", originalFileName);
        resultMap.put("filePathName", uploadPath + savedFileName);
        resultMap.put("serverfileName",savedFileName);

        return resultMap;
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
}
