package com.btone.web.home.domain.regist.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.btone.web.home.domain.regist.vo.UserVO;

@Mapper
public interface RegistMapper {
	//회원ID 중복체크
	int idChk(String userId);

	// 회원가입
	int join(UserVO user);
}
