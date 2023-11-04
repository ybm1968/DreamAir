package com.joeun.dreamair.dto;

import java.util.Date;

import lombok.Data;

@Data
public class Files { 

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
