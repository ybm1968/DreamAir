package com.joeun.dreamair.dto;

import java.util.Date;

import lombok.Data;

@Data
public class Files {

    private int fileNo;
    private int board_no;
    private String parentTable;
    private int parentNo;
    private String fileName;
    private String originName;
    private String filePath;
    private long fileSize;
    private String regDate;
    private String updDate;
    private int fileCode;
    private String fileType;
    
}
