package com.btone.web.home.domain.board.vo;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonProperty;

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
	@JsonProperty("cNo")
	private int cNo;
	private int userNo;
	private  String boardTitle;
	private String boardContent;
	private LocalDate createDate;
	private LocalDate updateDate;
	//조회수
	private int boardHits;

}
