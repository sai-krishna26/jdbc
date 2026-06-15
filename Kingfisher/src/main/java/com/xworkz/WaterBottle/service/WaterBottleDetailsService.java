package com.xworkz.WaterBottle.service;

import com.xworkz.WaterBottle.dto.WaterBottleDetailsDto;

public interface WaterBottleDetailsService {
    public boolean validatingSave(WaterBottleDetailsDto waterBottleDetailsDto);
    public int validatingUpdate(String name, Double cost);
    public int validatingDelete(String name);
    public void validatingShowDetails();
}
