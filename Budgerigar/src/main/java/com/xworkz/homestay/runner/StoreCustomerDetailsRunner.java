package com.xworkz.homestay.runner;

import com.xworkz.homestay.dao.StoreCustomerDetailsDao;
import com.xworkz.homestay.dao.impl.StoreCustomerDetailsDaoImpl;
import com.xworkz.homestay.dto.StoreCustomerDetailsDto;

import java.time.LocalDate;

public class StoreCustomerDetailsRunner {
    public static void main(String[] args) {
        //insert
        StoreCustomerDetailsDao storeCustomerDetailsDao=new StoreCustomerDetailsDaoImpl();
        StoreCustomerDetailsDto storeCustomerDetailsDto=new StoreCustomerDetailsDto();
        storeCustomerDetailsDto.setName("anushka");
        storeCustomerDetailsDto.setGender("female");
        storeCustomerDetailsDto.setAge(28);
        storeCustomerDetailsDto.setGroup_count(2);
        storeCustomerDetailsDto.setCheckInDate(LocalDate.now());

        boolean check=storeCustomerDetailsDao.store(storeCustomerDetailsDto);
        System.out.println("data inserted succesfully");

        //update
        StoreCustomerDetailsDto storeCustomerDetailsDto1=new StoreCustomerDetailsDto();
        storeCustomerDetailsDto1.setGroup_count(9);
        storeCustomerDetailsDto1.setName("anushka");
        int up=storeCustomerDetailsDao.update(storeCustomerDetailsDto1);
        System.out.println("data updated successfully");

        //delete
        StoreCustomerDetailsDto storeCustomerDetailsDto2=new StoreCustomerDetailsDto();
        storeCustomerDetailsDto2.setAge(25);
        int del=storeCustomerDetailsDao.delete(storeCustomerDetailsDto2);
        System.out.println("data successfully deleted");

        //read
        StoreCustomerDetailsDto storeCustomerDetailsDto3=new StoreCustomerDetailsDto();
        storeCustomerDetailsDto3.setName("krishna");
        storeCustomerDetailsDao.read(storeCustomerDetailsDto3);
    }

}
