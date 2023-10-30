package com.joeun.dreamair.dto;

import java.util.Date;

import lombok.Data;

@Data
public class Comment {
    private int commentNo;
    private int boardNo;
    private String parentTable;
    private int parentNo;
    private String writer;
    private String content;
    private int groupNo;
    private int superNo;
    private int depthNo;
    private int seqNo;
    private Date regDate; 
    private Date updDate;
    private int subCount;
}
