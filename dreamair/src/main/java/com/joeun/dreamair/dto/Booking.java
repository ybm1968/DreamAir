package com.joeun.dreamair.dto;

import lombok.Data;

@Data
public class Booking {
    private int bookingNo;
    private String name;
    private String seatNo;
    private int userNo;
    private int userNo2;
    private int productNo;
    private int routeNo;
    private int pasCount;
    private int roundTrip;
    private String status;
}
