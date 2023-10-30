package com.joeun.dreamair.dto;

import java.util.Date;

import lombok.Data;

@Data
public class File {
    private int fileNo;
    private int boardNo;
    private String parentTable;
    private int parentNo;
    private String fileName;
    private String originName;
    private String filePath;
    private int fileSize;
    private Date regDate;
    private Date upDate;
    private int fileCode;
}
