package com.xworkz.WaterBottle.dao;

import com.xworkz.WaterBottle.dto.WaterBottleDetailsDto;

public interface WaterBottleDetailsDao {
    public boolean saveDetails(WaterBottleDetailsDto waterBottleDetailsDto);
    public int updateDetails(String name,Double cost);
    public int deleteDetails(String name);
    public void showDetails();
}
