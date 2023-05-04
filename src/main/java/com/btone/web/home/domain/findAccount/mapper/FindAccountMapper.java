package com.btone.web.home.domain.findAccount.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.btone.web.home.domain.login.vo.UserLoginVO;

@Mapper
public interface FindAccountMapper {
	// 로그인
	UserLoginVO loginUser(UserLoginVO userVO);
}
