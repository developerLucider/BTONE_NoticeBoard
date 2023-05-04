package com.btone.web.home.domain.findAccount.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.btone.web.home.domain.findAccount.vo.AccountVO;

@Mapper
public interface FindAccountMapper {
	// 로그인
	AccountVO findId(AccountVO accountVO);
}
