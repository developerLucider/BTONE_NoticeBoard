package com.btone.web.home.domain.board.controller;


import com.btone.web.home.domain.board.service.CommentService;
import com.btone.web.home.domain.board.vo.Comment;
import com.btone.web.home.domain.login.service.LoginService;
import com.btone.web.home.domain.login.vo.UserLoginVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping("/comments")
@Slf4j
public class CommentController {

    private CommentService commentService;
    private LoginService loginService;

    public CommentController(CommentService commentService, LoginService loginService) {
        this.commentService = commentService;
        this.loginService = loginService;
    }


    /**
     * 댓글 등록
     * @param comment
     */
    @PostMapping("/{boardNo}")
    @ResponseBody
    public int insertComments(@PathVariable int boardNo, @RequestBody Comment comment,HttpServletRequest request){
        log.info("comments reply controller");

        HttpSession httpSession = request.getSession();

        UserLoginVO loginUser = (UserLoginVO) httpSession.getAttribute("loginUser");

       comment.setUserId(loginUser.getUserId());
       comment.setBoardNo(boardNo);
       int result = commentService.insertComment(comment);

        // 데이터 확인을 위한 로그 출력
        log.debug("댓글 저장 결과: {}", result);
           
       return result;
    }

    /**
     * 대댓글 등록
     * @param comment
     */
    @PostMapping("/{boardNo}/{commentNo}")
    @ResponseBody
    public int insertReComments(@PathVariable int boardNo, @PathVariable Long commentNo, @RequestBody Comment comment, HttpServletRequest request){
        log.info("reComments controller");

        HttpSession httpSession = request.getSession();

        UserLoginVO loginUser = (UserLoginVO) httpSession.getAttribute("loginUser");

        comment.setUserId(loginUser.getUserId());
        comment.setBoardNo(boardNo);
        comment.setParentNo(commentNo);

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
    public List<Comment> getCommentList(@PathVariable int boardNo , HttpServletRequest request){
        log.info("---getCommentList controller---");

        HttpSession httpSession = request.getSession();

        UserLoginVO userLoginVO = (UserLoginVO) httpSession.getAttribute("loginUser");
        httpSession.setAttribute("loginUser", userLoginVO);

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