package com.joeun.dreamair.dto;

import java.util.Date;

import lombok.Data;

@Data
public class Board { 

    // board 테이블
    private int boardNo; 
    private String writer;
    private String title;
    private String content;
    private Date regDate;
    private Date updDate;
    private Date date;
    private int views;
    private int userNo;
    private int adminNo;
    private int like;

    // comment 테이블
    private int commentNo;
    private String parent_table;
    private int parent_no;
    private int groupNo;
    private int superNo;
    private int depthNo;
    private int seqNo;
    private int subCount;

    // file 테이블
    private int fileNo;
    private String parentTable;
    private int parentNo;
    private String fileName;
    private String originName;
    private String filePath;
    private int fileSize;
    private int fileCode;


}
