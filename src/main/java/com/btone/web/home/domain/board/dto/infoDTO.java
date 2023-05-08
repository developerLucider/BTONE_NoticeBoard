package com.btone.web.home.domain.board.dto;

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
@Setter
@Getter
public class infoDTO {
	private int boardNo;
	@JsonProperty("cNo")
	private int cNo;
	private String cName;
	private int userNo;
	private String userId;
	private  String boardTitle;
	private String boardContent;
	private LocalDate createDate;
	private LocalDate updateDate;
	private int boardHits;
	
	
	
}
