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
	
   private int board_No;
   private int c_No;
   private int user_No;
   private String board_Title;
   private String board_Content;
   private String create_Date;
   private String update_Date;
   
}
