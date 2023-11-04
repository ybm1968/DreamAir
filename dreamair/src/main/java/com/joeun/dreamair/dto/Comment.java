package com.joeun.dreamair.dto;

import java.util.Date;

import lombok.Data;

@Data
public class Comment { 

    // comment 테이블
    private int commentNo;
    private String parent_table;
    private int parent_no;
    private int groupNo;
    private int superNo;
    private int depthNo;
    private int seqNo;
    private int subCount;

}
