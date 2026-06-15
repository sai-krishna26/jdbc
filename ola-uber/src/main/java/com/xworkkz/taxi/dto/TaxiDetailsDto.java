package com.xworkkz.taxi.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TaxiDetailsDto {
    private String driverName;
    private String carName;
    private String license;
    private int passengerCount;
}
