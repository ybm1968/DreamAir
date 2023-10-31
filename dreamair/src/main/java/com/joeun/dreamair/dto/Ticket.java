package com.joeun.dreamair.dto;

import java.util.Date;

import lombok.Data;

@Data
public class Ticket {
    private int ticketNo;
    private int pinType;
    private String passengerNo;
    private String passengerName;
    private String departure;
    private String destination;
    private Date boarding;
    private Date departureTime;
    private Date destinationTime;
    private Date duration;
    private int checkedIn;
    private int isBoarded;
}
