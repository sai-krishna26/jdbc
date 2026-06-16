package com.xworkz.WaterBottle.service.impl;

import com.xworkz.WaterBottle.dao.WaterBottleDetailsDao;
import com.xworkz.WaterBottle.dto.WaterBottleDetailsDto;
import com.xworkz.WaterBottle.service.WaterBottleDetailsService;
import lombok.AllArgsConstructor;

import java.util.Objects;
@AllArgsConstructor
public class WaterBottleDetailsServiceImpl implements WaterBottleDetailsService {
    WaterBottleDetailsDao waterBottleDetailsDao;
    @Override
    public boolean validatingSave(WaterBottleDetailsDto waterBottleDetailsDto) {
        if(Objects.nonNull(waterBottleDetailsDao) && waterBottleDetailsDto.getName()!=null && waterBottleDetailsDto.getSize()>=1 && waterBottleDetailsDto.getCost()>=10 && waterBottleDetailsDto.getValidity()!=null && waterBottleDetailsDto.isCertified())
        {
            return this.waterBottleDetailsDao.saveDetails(waterBottleDetailsDto);
        }
        else
        {
            System.err.println("null's are not acceptable and check others values!");
        }
        return false;
    }

    @Override
    public int validatingUpdate(String name, Double cost) {
        if(Objects.nonNull(waterBottleDetailsDao) && name!=null && cost>=10)
        {
            return this.waterBottleDetailsDao.updateDetails(name, cost);
        }
        else
        {
            System.err.println("name and reference should not be null");
        }
        return 0;
    }

    @Override
    public int validatingDelete(String name) {
        if(Objects.nonNull(waterBottleDetailsDao) && name!=null)
        {
            return this.waterBottleDetailsDao.deleteDetails(name);
        }
        else
        {
            System.err.println("name and reference should not be null");
        }
        return 0;
    }

    @Override
    public void validatingShowDetails() {
        if(Objects.nonNull(waterBottleDetailsDao))
        {
            this.waterBottleDetailsDao.readDetails();
        }
        else
        {
            System.err.println("reference should not be null");

        }
    }
}
