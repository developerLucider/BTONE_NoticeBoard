package com.btone.web.board.vo;

import lombok.Data;

@Data
public class BoardVO {
	
	private int boardNo;
	
	private int cNo;
	
	private int userNo;
	
	private String boardTitle;
	
	private String boardContent;
	
	private String createDate;
	
	private String updateDate;
	
	private String boardHits;
}
