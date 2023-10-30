package com.joeun.dreamair.dto;

import lombok.Data;

@Data
public class Seat {
    private String seatNo;
    private int userNo;
    private int userNo2;
    private int bookingNo;
    private int productNo;
    private int routeNo;
    private String passengerName;
    private int flightNo;
    private String seatClass;
    private String status;
}
