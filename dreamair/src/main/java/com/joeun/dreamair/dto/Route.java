package com.joeun.dreamair.dto;

import java.util.Date;

import lombok.Data;

@Data
public class Route {
    private int routeNo;
    private String departure;
    private String destination;
    private Date departureTime;
    private Date destinationTime;
}
