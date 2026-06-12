package com.xworkz.WaterBottle.dao;

import com.xworkz.WaterBottle.dto.WaterBottleDetailsDto;

public interface WaterBottleDetailsDao {
    public boolean saveDetails(WaterBottleDetailsDto waterBottleDetailsDto);
    public int updateDetails(WaterBottleDetailsDto waterBottleDetailsDto);
    public int deleteDetails(WaterBottleDetailsDto waterBottleDetailsDto);
    public void showDetails(WaterBottleDetailsDto waterBottleDetailsDto);
}
