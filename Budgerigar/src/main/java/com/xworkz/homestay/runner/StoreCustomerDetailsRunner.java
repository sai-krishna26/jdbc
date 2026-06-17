package com.xworkz.homestay.runner;

import com.xworkz.homestay.Service.StoreCustomerDetailsService;
import com.xworkz.homestay.Service.impl.StoreCustomerDetailsServiceImpl;
import com.xworkz.homestay.dao.StoreCustomerDetailsDao;
import com.xworkz.homestay.dao.impl.StoreCustomerDetailsDaoImpl;
import com.xworkz.homestay.dto.StoreCustomerDetailsDto;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class StoreCustomerDetailsRunner {
    public static void main(String[] args) {
        //insert
        StoreCustomerDetailsDao storeCustomerDetailsDao=new StoreCustomerDetailsDaoImpl();
        StoreCustomerDetailsService storeCustomerDetailsService=new StoreCustomerDetailsServiceImpl(storeCustomerDetailsDao);
//        StoreCustomerDetailsDto storeCustomerDetailsDto=new StoreCustomerDetailsDto();
//        storeCustomerDetailsDto.setName("anushka");
//        storeCustomerDetailsDto.setGender("female");
//        storeCustomerDetailsDto.setAge(28);
//        storeCustomerDetailsDto.setGroup_count(2);
//        storeCustomerDetailsDto.setCheckInDate(LocalDate.now());
//        storeCustomerDetailsService.validateStore(storeCustomerDetailsDto);

//        //update
//        StoreCustomerDetailsDto storeCustomerDetailsDto1=new StoreCustomerDetailsDto();
//        storeCustomerDetailsDto1.setGroup_count(20);
//        storeCustomerDetailsDto1.setName("anushka");
//        storeCustomerDetailsService.validateUpdate(storeCustomerDetailsDto1.getName(),storeCustomerDetailsDto1.getGroup_count());
//

//        //delete
//        StoreCustomerDetailsDto storeCustomerDetailsDto2=new StoreCustomerDetailsDto();
//        storeCustomerDetailsDto2.setAge(25);
//        storeCustomerDetailsService.validateDelete(storeCustomerDetailsDto2.getAge());

        //read
        //StoreCustomerDetailsDto storeCustomerDetailsDto3=new StoreCustomerDetailsDto();
//        List<StoreCustomerDetailsDto> storeCustomerDetailsDtos=storeCustomerDetailsDao.read();
//        System.out.println("----------read-----------");
//        for(StoreCustomerDetailsDto ref:storeCustomerDetailsDtos )
//        {
//            System.out.println(ref);
//        }
//        storeCustomerDetailsService.validateRead();
//        System.out.println("-------------------------------------------------------------");

        //batch insert
        List<StoreCustomerDetailsDto> dto=new ArrayList<>();
        StoreCustomerDetailsDto storeCustomerDetailsDto0=new StoreCustomerDetailsDto();
        storeCustomerDetailsDto0.setName("prabhu");
        storeCustomerDetailsDto0.setGender("male");
        storeCustomerDetailsDto0.setAge(24);
        storeCustomerDetailsDto0.setGroup_count(5);
        storeCustomerDetailsDto0.setDate(LocalDate.of(2025,6,4));

        StoreCustomerDetailsDto storeCustomerDetailsDto4=new StoreCustomerDetailsDto();
        storeCustomerDetailsDto4.setName("devika");
        storeCustomerDetailsDto4.setGender("female");
        storeCustomerDetailsDto4.setAge(28);
        storeCustomerDetailsDto4.setGroup_count(2);
        storeCustomerDetailsDto4.setDate(LocalDate.of(2026,3,9));

        StoreCustomerDetailsDto storeCustomerDetailsDto5=new StoreCustomerDetailsDto();
        storeCustomerDetailsDto5.setName("ram-lakshman");
        storeCustomerDetailsDto5.setGender("male");
        storeCustomerDetailsDto5.setAge(45);
        storeCustomerDetailsDto5.setGroup_count(9);
        storeCustomerDetailsDto5.setDate(LocalDate.of(2024,6,23));

        dto.add(storeCustomerDetailsDto0);
        dto.add(storeCustomerDetailsDto4);
        dto.add(storeCustomerDetailsDto5);

        storeCustomerDetailsService.ValidateBatchInsert(dto);
    }

}
