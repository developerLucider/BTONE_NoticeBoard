package com.btone.web.home.domain.board.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.btone.web.home.domain.board.dto.infoDTO;
import com.btone.web.home.domain.board.vo.Board;
import com.btone.web.home.domain.board.vo.BoardVO;
import com.btone.web.home.domain.board.vo.Category;

@Mapper
public interface BoardMapper {
	//게시글 조회
	List<BoardVO> selectBoard(int cNo);
	
	int addContent(Board board);
	
	int findId();

	//조회수
	int updateHits(int bno);
	infoDTO getBoardInfo(int bno);

	List<Category> selectCategory();

	int updateContent(Board board);

	void deleteContent(int boardNo);

}
