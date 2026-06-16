package com.xworkz.WaterBottle.dao;

import com.xworkz.WaterBottle.dto.WaterBottleDetailsDto;

import java.util.List;

public interface WaterBottleDetailsDao {
    public boolean saveDetails(WaterBottleDetailsDto waterBottleDetailsDto);
    public int updateDetails(String name,Double cost);
    public int deleteDetails(String name);
    public List<WaterBottleDetailsDto> readDetails();
}
