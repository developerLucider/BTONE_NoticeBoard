package com.btone.web.home.domain.board.controller;


import com.btone.web.home.domain.board.service.CommentService;
import com.btone.web.home.domain.board.vo.Board;
import com.btone.web.home.domain.board.vo.Comment;
import javassist.NotFoundException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Controller
@RequestMapping("/comments")
@Slf4j
public class CommentController {

    private CommentService commentService;

    @Autowired
    public CommentController(CommentService commentService) {
        this.commentService = commentService;
    }


    /**
     * 댓글 등록
     * @param comment
     */
    @PostMapping("/{boardNo}")
    @ResponseBody
    public int insertComments(@RequestBody Comment comment){
        log.info("comments reply controller");
         int result = commentService.insertComment(comment);
         return result;
    }

    /**
     * 대댓글 등록
     * @param comment
     */
    @PostMapping("/{boardNo}/{commentNo}")
    @ResponseBody
    public int insertReComments(@RequestBody Comment comment){
        log.info("reComments controller");

        int result =  commentService.insertReComment(comment);

        return result;
    }

    /**
     * 댓글 개수 조회
     * @param boardNo
     * @return
     */
    @GetMapping("/count/{boardNo}")
    @ResponseBody
    public int getCommentCount(@PathVariable int boardNo){
        return commentService.getCommentCountByBoardNo(boardNo);
    }

    /**
     * 댓글,대댓글 조회 및 개수 조회
     * @param boardNo
     * @return
     */
    @GetMapping("/{boardNo}")
    @ResponseBody
    public List<Comment> getCommentList(@PathVariable int boardNo){
        log.info("---getCommentList controller---");

        // 댓글 리스트
        List<Comment> comments = commentService.findBoardNoByComments(boardNo);
        return comments;
    }


    /**
     * 댓글 삭제
     * @param commentNo
     */
    @DeleteMapping("/{commentNo}")
    public ResponseEntity<String> deleteComment(@PathVariable Long commentNo) {
        // 부모 댓글 삭제
        commentService.deleteComment(commentNo);
        return ResponseEntity.ok("댓글이 삭제되었습니다.");
    }

    /**
     * 대댓글 삭제
     * @param replyNo
     * @return
     */
    @DeleteMapping("/replies/{parentNo}")
    public ResponseEntity<String> deleteReply(@PathVariable Long parentNo) {
        // 대댓글 삭제
        commentService.deleteReply(parentNo);
        return ResponseEntity.ok("대댓글이 삭제되었습니다.");
    }

//    /**
//     * 댓글 수정
//     * @param commentNo
//     * @param comment
//     * @return
//     */
//    @PutMapping("/{commentNo}")
//    @ResponseBody
//    public Comment updateComments(@PathVariable Long commentNo, @RequestBody Comment comment){
//        log.info("---updateComments controller---");
//        commentService.updateComment(comment);
//        return commentService.findByCommentNo(commentNo);
//    }

}