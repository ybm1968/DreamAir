package com.joeun.dreamair.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.joeun.dreamair.dto.Booking;
import com.joeun.dreamair.dto.Users;

@Mapper
public interface BookingMapper {

    // 가는편 항공권 목록 조회
    public List<Booking> golist(Booking booking) throws Exception;
    
    // 오는편 항공권 목록 조회
    public List<Booking> comelist(Booking booking) throws Exception;
    
    // 탑승객 정보 입력
    public int infoPassngers(Booking booking) throws Exception;

    // 여권 정보 입력
    public int infoPassport(Users user) throws Exception;
    
    // 가는편 선택한 항공 스케줄(탑승객 유의사항 안내)
    public List<Booking> goScheduleList(Booking booking) throws Exception;
    
    // 오는편 선택한 항공 스케줄(탑승객 유의사항 안내)
    public List<Booking> comeScheduleList(Booking booking) throws Exception;
}
