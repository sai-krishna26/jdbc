package com.xworkz.softwares.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDate;

@Getter
@Setter
@ToString
public class SoftwareDto {
    private String name;
    private String currentVersion;
    private int developedDate;
    private String developedBy;
    private String isOpenSource;
}
