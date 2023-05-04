package com.btone.web.home.domain.login.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.btone.web.home.domain.login.vo.UserLoginVO;

@Mapper
public interface LoginMapper {
	// 로그인
	UserLoginVO loginUser(UserLoginVO userVO);
}
