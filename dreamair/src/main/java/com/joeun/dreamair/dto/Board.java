package com.joeun.dreamair.dto;

import java.util.Date;
import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import lombok.Data;

@Data
public class Board { 

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
<<<<<<< HEAD

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
=======
    private List<Files> files;
    private Files thumbnail;
>>>>>>> origin/main
    private String fileName;
    private String fileType;
    
     private List<MultipartFile> file;


<<<<<<< HEAD

=======
>>>>>>> origin/main
}
