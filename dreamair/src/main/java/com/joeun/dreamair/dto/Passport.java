package com.joeun.dreamair.dto;

import lombok.Data;

@Data
public class Passport {
    private String passportNo;
    private int pinType;
    private int userNo;
    private int userNo2;
    private String lastName;
    private String firstName;
    private String nationality;
    private String expirationDate;
}
