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
public class BoardVO {

	private int boardNo;
	private int cNo;
	private int userNo;
	private String boardTitle;
	private String boardContent;
	private String createDate;
	private String updateDate;
	

}
