package com.joeun.dreamair.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ModelAttribute;

import com.joeun.dreamair.dto.Comment;
import com.joeun.dreamair.mapper.CommentMapper;

@Service
public class CommentServiceImpl implements CommentService {
    
    @Autowired
    private CommentMapper commentMapper;

    @Override
    public List<Comment> list() throws Exception {
       List<Comment> commentList = commentMapper.list();

       return commentList;
    }

    @Override
    public Comment select(int commentNo) throws Exception {
        Comment comment = commentMapper.select(commentNo);
        return comment;
    }

    @Override
    public int insert(Comment comment) throws Exception {
         int result = commentMapper.insert(comment);
        String parentTable = "parentNo";
        
        return result;
    }

    @Override
    public int update(Comment comment) throws Exception {
        int result = commentMapper.update(comment);
        return result;
    }

    @Override
    public int delete(int commentNo) throws Exception {
        int result = commentMapper.delete(commentNo);
        return result;
        
    }

    @Override
    public List<Comment> listByBoard(int boardNo) throws Exception  { 
       List<Comment> commentList = commentMapper.listByBoard(boardNo);
       return commentList;
    }
}