package com.btone.web.home.domain.board.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Getter
@Setter
public class BoardFile {

	private int boardNo;
	private String fileType;
	private String fileOriginName;
	private String fileName;
}
