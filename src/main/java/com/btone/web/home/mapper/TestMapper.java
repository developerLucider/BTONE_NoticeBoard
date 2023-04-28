package com.btone.web.home.mapper;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface TestMapper {

	// 스트링 테스트
	public String getTestString();		

}
