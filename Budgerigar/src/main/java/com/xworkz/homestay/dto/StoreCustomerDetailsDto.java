package com.xworkz.homestay.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
@Getter
@Setter
public class StoreCustomerDetailsDto {
    private String name;
    private String gender;
    private int age;
    private int group_count;
    private LocalDate checkInDate;
}
