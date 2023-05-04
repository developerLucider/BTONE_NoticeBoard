package com.btone.web.home.domain.board.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.btone.web.home.domain.board.vo.Board;
import com.btone.web.home.domain.board.vo.BoardVO;

@Mapper
public interface BoardMapper {
	//게시글 조회
	List<BoardVO> selectBoard(int cNo);
	
	int addContent(Board board);

	Board getBoardInfo(int bno);
}
