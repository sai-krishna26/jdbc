package com.xworkz.WaterBottle.runner;

import com.xworkz.WaterBottle.dao.WaterBottleDetailsDao;
import com.xworkz.WaterBottle.dao.impl.WaterBottleDetailsDaoImpl;
import com.xworkz.WaterBottle.dto.WaterBottleDetailsDto;
import com.xworkz.WaterBottle.service.WaterBottleDetailsService;
import com.xworkz.WaterBottle.service.impl.WaterBottleDetailsServiceImpl;

import java.sql.ResultSet;
import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.List;

public class waterBottleDetailsRunner {
    public static void main(String[] args) {
//       System.out.println("-------------------insert----------------------");
        WaterBottleDetailsDao waterBottleDetailsDao=new WaterBottleDetailsDaoImpl();
        WaterBottleDetailsService waterBottleDetailsService=new WaterBottleDetailsServiceImpl(waterBottleDetailsDao);
//        WaterBottleDetailsDto waterBottleDetailsDto=new WaterBottleDetailsDto();
//        waterBottleDetailsDto.setName("h2o");
//        waterBottleDetailsDto.setSize(3.0f);
//        waterBottleDetailsDto.setCost(-40);
//        waterBottleDetailsDto.setValidity("1year");
//        waterBottleDetailsDto.setCertified(true);
//        waterBottleDetailsService.validatingSave(waterBottleDetailsDto);

//        System.out.println("---------update------------------");
//        WaterBottleDetailsDto waterBottleDetailsDto1=new WaterBottleDetailsDto();
//        waterBottleDetailsDto1.setCost(30.05);
//        waterBottleDetailsDto1.setName("signature_mrs");
//        int update=waterBottleDetailsService.validatingUpdate(waterBottleDetailsDto1.getName(), waterBottleDetailsDto1.getCost());
//        System.out.println("how many rows updated?: "+update);
//        System.out.println("requirements updated successfully");

//        System.out.println("-----------delete----------------");
//        WaterBottleDetailsDto waterBottleDetailsDto2=new WaterBottleDetailsDto();
//        waterBottleDetailsDto2.setName(null);
//        waterBottleDetailsService.validatingDelete(waterBottleDetailsDto2.getName());

//        System.out.println("------------read-----------------");
//        List<WaterBottleDetailsDto> waterBottleDetailsDtos=waterBottleDetailsService.validatingShowDetails();
//        for (WaterBottleDetailsDto ref:waterBottleDetailsDtos)
//        {
//            System.out.println(ref);
//            System.out.println(".............................................................................");
//        }


        List<WaterBottleDetailsDto> waterBottleDetailsDtoList=new ArrayList<>();

        WaterBottleDetailsDto waterBottleDetailsDto5=new WaterBottleDetailsDto();
        waterBottleDetailsDto5.setName(null);
        waterBottleDetailsDto5.setSize(1.50f);
        waterBottleDetailsDto5.setCost(12);
        waterBottleDetailsDto5.setValidity("2 year");
        waterBottleDetailsDto5.setCertified(true);

        WaterBottleDetailsDto waterBottleDetailsDto6=new WaterBottleDetailsDto();
        waterBottleDetailsDto6.setName("american_kf");
        waterBottleDetailsDto6.setSize(2.5f);
        waterBottleDetailsDto6.setCost(50);
        waterBottleDetailsDto6.setValidity("1.8 year");
        waterBottleDetailsDto6.setCertified(true);

        waterBottleDetailsDtoList.add(waterBottleDetailsDto5);
        waterBottleDetailsDtoList.add(waterBottleDetailsDto6);
        waterBottleDetailsService.ValidateBatchInsert(waterBottleDetailsDtoList);
    }
}
