package com.btone.web.home.domain.home.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.btone.web.home.domain.board.vo.Board;
import com.btone.web.home.domain.board.vo.BoardVO;
import com.btone.web.home.domain.board.vo.Category;

@Mapper
public interface HomeMapper {

	public List<Board> getList();

	public List<Board> getSearch(@Param ("search") String search, @Param ("type")  String type);
	
	//카테고리 리스트 가져오기
	public List<Category> getCate();
}
