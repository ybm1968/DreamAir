package com.joeun.dreamair.dto;

import java.util.Date;

import lombok.Data;

@Data
public class Comment {

    private int commentNo;
    private int board_no;
    private String parent_table;
    private int parent_no;
    private int parentNo;
    
    private String writer;
    private String content;
    private int groupNo;
    private int superNo;
    private int depthNo;
    private int seqNo;
    private String reg_date;
    private String upd_date;
    private int subCount;
    private String parentTable;
}
