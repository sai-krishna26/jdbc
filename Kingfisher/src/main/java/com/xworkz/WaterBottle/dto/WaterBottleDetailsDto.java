package com.xworkz.WaterBottle.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class WaterBottleDetailsDto {
    private String name;
    private float size;
    private double cost;
    private String validity;
    private boolean isCertified;
}
