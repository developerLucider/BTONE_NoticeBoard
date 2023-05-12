package com.btone.web.home.domain.board.mapper;

import com.btone.web.home.domain.board.vo.Comment;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface CommentMapper {

    /* 댓글 등록 */
    int insertComment(Comment comment);

    /* 대댓글 등록 */
    int insertReplyComment(Comment comment);

    /* 게시글의 댓글 목록 조회 */
    List<Comment> readCommentsByBoardNo(int boardNo);

    /* 게시글의 댓글 개수 */
    int getCommentCountByBoardNo(int boardNo);

    /* 댓글의 대댓글 개수 */
    int readCommentsCountByParentNo(Long parentNo);

    /* 댓글 수정 */
    int updateComment(Comment comment);

    Comment getCommentByNo(Long commentNo);

    List<Comment> getRepliesByParentNo(Long parentNo);

    void deleteComment(Long commentNo);

    void updateCommentDeleted(Long commentNo, String isDeleted);

}
