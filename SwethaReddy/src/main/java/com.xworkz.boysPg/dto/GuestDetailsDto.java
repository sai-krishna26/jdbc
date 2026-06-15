package com.xworkz.boysPg.dto;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.time.LocalDate;

@Getter
@Setter
public class GuestDetailsDto implements Serializable {
    private String guest_name;
    private long aadhaarId;
    private String address;
    private String work;
    private int days_count;
}
