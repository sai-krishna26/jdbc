package com.xworkz.WaterBottle.runner;

import com.xworkz.WaterBottle.dao.WaterBottleDetailsDao;
import com.xworkz.WaterBottle.dao.impl.WaterBottleDetailsDaoImpl;
import com.xworkz.WaterBottle.dto.WaterBottleDetailsDto;

import java.sql.ResultSet;
import java.sql.SQLOutput;

public class waterBottleDetailsRunner {
    public static void main(String[] args) {
        //System.out.println("-------------------insert----------------------");
        WaterBottleDetailsDao waterBottleDetailsDao=new WaterBottleDetailsDaoImpl();
        /*WaterBottleDetailsDto waterBottleDetailsDto=new WaterBottleDetailsDto();
        waterBottleDetailsDto.setName("kf_blackwater");
        waterBottleDetailsDto.setSize(2.0f);
        waterBottleDetailsDto.setCost(50.00);
        waterBottleDetailsDto.setValidity("2 year");
        waterBottleDetailsDto.setCertified(true);
        boolean save=waterBottleDetailsDao.saveDetails(waterBottleDetailsDto);
        System.out.println("inserted?: "+save);
        System.out.println("details are successfully inserted");*/

        /*System.out.println("---------update------------------");
        WaterBottleDetailsDto waterBottleDetailsDto1=new WaterBottleDetailsDto();
        waterBottleDetailsDto1.setCost(20.05);
        waterBottleDetailsDto1.setName("signature_mrs");
        int update=waterBottleDetailsDao.updateDetails(waterBottleDetailsDto1);
        System.out.println("how many rows updated?: "+update);
        System.out.println("requirements updated successfully");*/

        /*System.out.println("-----------delete----------------");
        WaterBottleDetailsDto waterBottleDetailsDto2=new WaterBottleDetailsDto();
        waterBottleDetailsDto2.setName("signature_mrs");
        int delete=waterBottleDetailsDao.deleteDetails(waterBottleDetailsDto2);
        System.out.println("how many rows deleted?: "+delete);
        System.out.println("requirements deleted successfully");*/

        System.out.println("------------read-----------------");
        WaterBottleDetailsDto waterBottleDetailsDto3=new WaterBottleDetailsDto();
        waterBottleDetailsDto3.setName("kf_blackwater");
        waterBottleDetailsDao.showDetails(waterBottleDetailsDto3);
    }
}
