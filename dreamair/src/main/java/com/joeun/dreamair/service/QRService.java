package com.joeun.dreamair.service;

import java.util.List;

import com.joeun.dreamair.dto.QR;

public interface QRService {

    // ✅ QR 코드 생성
    public int makeQR(QR qr) throws Exception;

    // QR 목록
    public List<QR> list() throws Exception;

    // QR 조회
    public QR select(int qrNo) throws Exception;

    // QR 등록
    public int insert(QR qr) throws Exception;

    // QR 수정
    public int update(QR qr) throws Exception;

    // QR 삭제
    public int delete(int qrNo) throws Exception;
    
    // QR 목록 - 부모 기준
    public List<QR> listByParent(QR qr) throws Exception;
    
    // QR 삭제 - 부모 기준
    public int deleteByParent(QR qr) throws Exception;

}