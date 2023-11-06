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
    private List<Files> files;
    private Files thumbnail;
    private String fileName;
    private String fileType;
    
     private List<MultipartFile> file;


}
