package com.btone.web.home.domain.board.vo;

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
public class Category {

	@JsonProperty("cNo")
	private int cNo;
	@JsonProperty("cName")
	private String cName;
	
}
