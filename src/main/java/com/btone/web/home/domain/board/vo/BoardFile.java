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
	private int fileNo;
	private String fileOriginName;
	private String fileSaveName;
}
