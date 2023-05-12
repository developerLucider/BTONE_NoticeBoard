package com.btone.web.home.domain.board.vo;

import lombok.*;
import java.time.LocalDateTime;


@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Comment {

    private Long commentNo; // 댓글 번호(시퀀스)
    private int boardNo; // 게시길 번호
    private String userId; // 유저 아이디
    private String commentContent; // 댓글 내용
    private Long parentNo; // 대댓글을 위한 기존 댓글 번호
    private LocalDateTime createDate; // 댓글 작성일
    private LocalDateTime modifyDate; // 댓글 수정일
    private String isDeleted; // 댓글 삭제 여부

}
