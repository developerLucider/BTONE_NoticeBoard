package com.btone.web.home.domain.board.vo;

import java.time.LocalDate;

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
public class Board {
	

	private int boardNo;
	private int cNo;
	private int userNo;
	private String boardTitle;
	private String boardContent;
	private LocalDate createDate;
	private LocalDate updateDate;
	private int boardHits;

}
