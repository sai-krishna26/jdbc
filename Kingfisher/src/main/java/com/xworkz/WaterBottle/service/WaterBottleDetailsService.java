package com.xworkz.WaterBottle.service;

import com.xworkz.WaterBottle.dto.WaterBottleDetailsDto;

import java.util.List;

public interface WaterBottleDetailsService {
    public boolean validatingSave(WaterBottleDetailsDto waterBottleDetailsDto);
    public int validatingUpdate(String name, Double cost);
    public int validatingDelete(String name);
    public List<WaterBottleDetailsDto> validatingShowDetails();
    public String ValidateBatchInsert(List<WaterBottleDetailsDto> waterBottleDetailsDtoList);
}
