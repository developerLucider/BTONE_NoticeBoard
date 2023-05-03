package com.btone.web.home.domain.regist.vo;

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
public class UserVO {
   private String userId;
   private String userPassword;
   private String userName;
   private String userEmail;
}