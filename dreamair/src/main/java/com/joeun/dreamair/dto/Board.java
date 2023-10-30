package com.joeun.dreamair.dto;

import java.util.Date;

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
}
