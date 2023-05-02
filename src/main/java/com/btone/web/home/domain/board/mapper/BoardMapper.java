package com.btone.web.home.domain.board.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.btone.web.home.domain.board.vo.Board;

@Mapper
public interface BoardMapper {

	int addContent(Board board);
}
