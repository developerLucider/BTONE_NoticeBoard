package com.btone.web.home.domain.certify.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.btone.web.home.domain.findAccount.vo.AccountVO;

@Mapper
public interface CertifyMapper {
	// 아이디 찾기
	AccountVO findId(AccountVO accountVO);
	
	// 비밀번호 찾기
	AccountVO findPw(AccountVO accountVO);
}
