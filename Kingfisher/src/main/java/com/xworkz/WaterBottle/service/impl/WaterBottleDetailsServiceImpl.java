package com.xworkz.WaterBottle.service.impl;

import com.xworkz.WaterBottle.dao.WaterBottleDetailsDao;
import com.xworkz.WaterBottle.dto.WaterBottleDetailsDto;
import com.xworkz.WaterBottle.service.WaterBottleDetailsService;
import lombok.AllArgsConstructor;

import java.util.ArrayList;
import java.util.List;
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
    public List<WaterBottleDetailsDto> validatingShowDetails() {
        if (Objects.isNull(waterBottleDetailsDao)) {
            throw new RuntimeException("waterBottleDetailsDao is null");
        }

        return waterBottleDetailsDao.readDetails();
    }

    @Override
    public String ValidateBatchInsert(List<WaterBottleDetailsDto> waterBottleDetailsDtoList) {
    if(Objects.isNull(waterBottleDetailsDao))
        {
            System.out.println("Dao reference is null");
            return "Dao reference is null";
        }
    if (Objects.isNull(waterBottleDetailsDtoList) ||waterBottleDetailsDtoList.isEmpty())
    {
        System.out.println("list should not be empty and null");
        return "list should not be empty and null";
    }

    for(WaterBottleDetailsDto dto:waterBottleDetailsDtoList)
    {
        if(Objects.isNull(dto))
        {
            System.out.println("Dto is value is null");
            return "Dto is value is null";
        }

        if(dto.getName()==null || dto.getSize()<1 || dto.getCost()<10 || dto.getValidity()==null || dto.isCertified())
        {
            System.out.println("invalid data:"+dto);
            return "invalid data:"+dto;
        }
    }
    waterBottleDetailsDao.batchInsert(waterBottleDetailsDtoList);
        return "successfully inserted batch";
    }
}
