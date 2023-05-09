package com.btone.web.home.domain.board.service;

import com.btone.web.home.domain.board.mapper.CommentMapper;
import com.btone.web.home.domain.board.vo.Comment;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;

@Service
@Slf4j
public class CommentService {

    CommentMapper commentMapper;


    public CommentService(CommentMapper commentMapper) {
        this.commentMapper = commentMapper;
    }


    /**
     * 게시글의 댓글 목록
     *
     * @param boardNo
     */
    public List<Comment> findBoardNoByComments(int boardNo) {
        log.info("commentList service");
        List<Comment> comments = commentMapper.readCommentsByBoardNo(boardNo);
        return comments;
    }

    /**
     * 게시글의 댓글 개수
     *
     * @param boardNo
     * @return
     */
    public int getCommentCountByBoardNo(int boardNo) {
        return commentMapper.getCommentCountByBoardNo(boardNo);
    }

    /**
     * 댓글 저장
     *
     * @param comment
     * @author 박상훈
     */
    public int insertComment(Comment comment) {

        log.info("comment service-------------");

        int count = commentMapper.insertComment(comment);

        return count;
    }

    /**
     * 대댓글 저장
     *
     * @param comment
     * @author 박상훈
     */
    public int insertReComment(Comment comment) {
        log.info("------- reComment service -----------");

        Comment reCommentSave = new Comment();
        reCommentSave.setBoardNo(comment.getBoardNo());
        reCommentSave.setCommentContent(comment.getCommentContent());
        reCommentSave.setParentNo(comment.getParentNo());
        reCommentSave.setCreateDate(LocalDateTime.now());

        int result = commentMapper.insertReplyComment(reCommentSave);

        return result;
    }

//    /**
//     * 댓글 수정
//     * @return
//     */
//    public int updateComment(Comment comment){
//        log.info("updateComment service");
//
//        commentMapper.updateComment(comment);
//
//        return comment.getCommentNo(comment.getCommentNo());
//    }

    /**
     * 댓글 삭제
     *
     * @param commentNo
     * @author 박상훈
     */
    public void deleteComment(Long commentNo) {
        // 댓글 정보 가져오기
        Comment comment = commentMapper.getCommentByNo(commentNo);
        if (comment != null) {
            // 대댓글 목록 가져오기
            List<Comment> replies = commentMapper.getRepliesByParentNo(commentNo);

            if (!replies.isEmpty()) {
                // 부모 댓글의 is_deleted를 "Y"로 업데이트
                commentMapper.updateCommentDeleted(commentNo, "Y");
            } else {
                // 대댓글이 없는 경우
                commentMapper.deleteComment(commentNo); // 부모 댓글 완전히 삭제
            }
        }
    }

    /**
     * 대댓글 삭제
     *
     * @param commentNo
     */
    public void deleteReply(Long commentNo) {
        // 대댓글 삭제
        Comment deletedReply = commentMapper.getCommentByNo(commentNo); // 삭제될 대댓글 정보 가져오기
        commentMapper.deleteComment(commentNo);

        // 대댓글 삭제 후 부모 댓글 확인
        if (deletedReply != null && deletedReply.getParentNo() != null) {
            Comment parentComment = commentMapper.getCommentByNo(deletedReply.getParentNo());

            if (parentComment != null) {
                // 부모 댓글의 대댓글 목록 가져오기
                List<Comment> replies = commentMapper.getRepliesByParentNo(parentComment.getCommentNo());

                // 대댓글이 없는 경우 부모 댓글 완전히 삭제
                if (replies.isEmpty()) {
                    commentMapper.deleteComment(parentComment.getCommentNo());

                }
            }
        }
    }
}

