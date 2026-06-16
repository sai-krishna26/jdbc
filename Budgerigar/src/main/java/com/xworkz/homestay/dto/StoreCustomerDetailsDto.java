package com.xworkz.homestay.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;
import java.time.LocalDate;
@Getter
@Setter
@ToString
public class StoreCustomerDetailsDto implements Serializable {
    private String name;
    private String gender;
    private int age;
    private int group_count;
    private LocalDate date;
}
