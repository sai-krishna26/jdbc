package com.xworkz.homestay.runner;

import com.xworkz.homestay.Service.StoreCustomerDetailsService;
import com.xworkz.homestay.Service.impl.StoreCustomerDetailsServiceImpl;
import com.xworkz.homestay.dao.StoreCustomerDetailsDao;
import com.xworkz.homestay.dao.impl.StoreCustomerDetailsDaoImpl;
import com.xworkz.homestay.dto.StoreCustomerDetailsDto;

import java.time.LocalDate;
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
        List<StoreCustomerDetailsDto> storeCustomerDetailsDtos=storeCustomerDetailsDao.read();
        System.out.println("----------read-----------");
        for(StoreCustomerDetailsDto ref:storeCustomerDetailsDtos )
        {
            System.out.println(ref);
        }
        storeCustomerDetailsService.validateRead();
        System.out.println("-------------------------------------------------------------");
    }

}
