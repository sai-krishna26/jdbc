package com.xworkz.boysPg.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;

@Getter
@Setter
@ToString
public class GuestDetailsDto implements Serializable {
    private String guest_name;
    private long aadhaarId;
    private String address;
    private String work;
    private int days_count;
}
