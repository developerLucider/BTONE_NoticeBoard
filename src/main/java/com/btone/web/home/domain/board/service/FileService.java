package com.btone.web.home.domain.board.service;

import java.io.File;
import java.util.UUID;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class FileService {

	/**
	 * 게시물에 첨부된 파일들을 디렉토리에 저장하고 저장이름생성
	 * 
	 * @author sojin
	 * @param multipartFile
	 * @param path
	 * @return DB에 저장될 저장이름
	 * @throws Exception
	 */
	public String saveFile(MultipartFile multipartFile, String path) throws Exception {
		if (multipartFile.isEmpty()) {
			return null;
		}

		// 1. 중복되지 않는 파일명 생성(UUID, Date)
		String fileName = UUID.randomUUID().toString();

		// 2. 확장자
		StringBuffer buffer = new StringBuffer();
		buffer.append(fileName);
		buffer.append("_");
		buffer.append(multipartFile.getOriginalFilename());

		// 3. 파일 저장
		File file = new File(path, buffer.toString());
		multipartFile.transferTo(file);

		// fileName 리턴
		return buffer.toString();
	}

}
