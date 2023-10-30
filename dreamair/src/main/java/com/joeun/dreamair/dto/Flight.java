package com.joeun.dreamair.dto;

import lombok.Data;

@Data
public class Flight {
    private int flightNo;
    private String flightName;
    private String seatNo;
    private int routeNo;
    private int seatMax;
    private int seatRemaining;
    private int seatUsed;
}
