package com.btone.web.home.domain.home.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.btone.web.home.domain.board.vo.Board;
import com.btone.web.home.domain.board.vo.BoardVO;

@Mapper
public interface HomeMapper {

	public List<Board> getList();
}
