package com.btone.web.board.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.btone.web.board.vo.BoardVO;

@Mapper
public interface BoardMapper {
	
	//게시글 추가
	public int addBoard(BoardVO boardVO);
}
