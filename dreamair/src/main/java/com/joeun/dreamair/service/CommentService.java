package com.joeun.dreamair.service;

import java.util.List;

import org.springframework.web.bind.annotation.ModelAttribute;

import com.joeun.dreamair.dto.Comment;

public interface CommentService {

    // 댓글 목록 가져오기
    public List<Comment> list() throws Exception;

    // 댓글 조회
    public Comment select(int commentNo) throws Exception;

    // 댓글 등록
    public int insert(Comment comment) throws Exception;

    // 댓글 수정
    public int update(Comment comment) throws Exception;

    // 댓글 삭제
    public int delete(int commentNo) throws Exception;

    public List<Comment> listByBoard(int boardNo) throws Exception;

    
}
