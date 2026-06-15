package com.xworkz.homestay.dto;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.time.LocalDate;
@Getter
@Setter
public class StoreCustomerDetailsDto implements Serializable {
    private String name;
    private String gender;
    private int age;
    private int group_count;
    private LocalDate checkInDate;
}
