package com.xworkz.WaterBottle.runner;

import com.xworkz.WaterBottle.dao.WaterBottleDetailsDao;
import com.xworkz.WaterBottle.dao.impl.WaterBottleDetailsDaoImpl;
import com.xworkz.WaterBottle.dto.WaterBottleDetailsDto;
import com.xworkz.WaterBottle.service.WaterBottleDetailsService;
import com.xworkz.WaterBottle.service.impl.WaterBottleDetailsServiceImpl;

import java.sql.ResultSet;
import java.sql.SQLOutput;

public class waterBottleDetailsRunner {
    public static void main(String[] args) {
       // System.out.println("-------------------insert----------------------");
        WaterBottleDetailsDao waterBottleDetailsDao=new WaterBottleDetailsDaoImpl();
        WaterBottleDetailsService waterBottleDetailsService=new WaterBottleDetailsServiceImpl(waterBottleDetailsDao);
//        WaterBottleDetailsDto waterBottleDetailsDto=new WaterBottleDetailsDto();
//        waterBottleDetailsDto.setName("yamuna");
//        waterBottleDetailsDto.setSize(3.0f);
//        waterBottleDetailsDto.setCost(40);
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
//        waterBottleDetailsDto2.setName("kf_coconut");
//        int delete=waterBottleDetailsDao.deleteDetails(waterBottleDetailsDto2.getName());
//        System.out.println("how many rows deleted?: "+delete);
//        System.out.println("rows deleted successfully");

        System.out.println("------------read-----------------");
        WaterBottleDetailsDto waterBottleDetailsDto3=new WaterBottleDetailsDto();
        //waterBottleDetailsDto3.setName("kf_blackwater");
        waterBottleDetailsService.validatingShowDetails();
    }
}
