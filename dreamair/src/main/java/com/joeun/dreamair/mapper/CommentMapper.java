package com.joeun.dreamair.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.web.bind.annotation.ModelAttribute;

import com.joeun.dreamair.dto.Comment;

@Mapper
public interface CommentMapper {
    
    // 기본 목록
    public List<Comment> list() throws Exception;
    // 기본 조회
    public Comment select(int commentNo) throws Exception;
    // 기본 등록
    public int insert(Comment comment) throws Exception;
    // 기본 수정
    public int update(Comment comment) throws Exception;
    // 기본 삭제
    public int delete(int commentNo) throws Exception;
    
     // 보드번호로 댓글 조회
    public List<Comment> listByBoard(int boardNo) throws Exception;

    Comment getComment(int commentNo);
    List<Comment> getAllComments();
    

}