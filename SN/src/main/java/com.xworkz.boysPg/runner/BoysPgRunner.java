package com.xworkz.boysPg.runner;

import com.xworkz.boysPg.dao.GuestDetailsDao;
import com.xworkz.boysPg.dao.Impl.GuestDetailsDaoImpl;
import com.xworkz.boysPg.dto.GuestDetailsDto;
import com.xworkz.boysPg.service.GuestDetailsService;
import com.xworkz.boysPg.service.impl.GuestDetailsServiceImpl;

import java.util.ArrayList;
import java.util.List;

public class BoysPgRunner {
    public static void main(String[] args)
    {
        //insert
        GuestDetailsDao guestDetailsDao=new GuestDetailsDaoImpl();
        GuestDetailsDto guestDetailsDto=new GuestDetailsDto();
        GuestDetailsService guestDetailsService=new GuestDetailsServiceImpl(guestDetailsDao);
//        guestDetailsDto.setGuest_name("narendra");
//        guestDetailsDto.setAadhaarId(345678987650L);
//        guestDetailsDto.setAddress("anantnagar t");
//        guestDetailsDto.setWork("manager tr");
//        guestDetailsDto.setDays_count(35);
//
//        boolean check=guestDetailsService.validateInsertDetails(guestDetailsDto);
//        System.out.println("data inserted successfully");

            //update
//        GuestDetailsDto guestDetailsDto1=new GuestDetailsDto();
//        guestDetailsDto1.setDays_count(15);
//        guestDetailsDto1.setGuest_name("pratheek");
//        guestDetailsService.validateUpdateDetails(guestDetailsDto1.getDays_count(), guestDetailsDto1.getGuest_name());
//        System.out.println("data updated successfully");

            //delete
//            GuestDetailsDto guestDetailsDto2=new GuestDetailsDto();
//            guestDetailsDto2.setGuest_name("anguru");
//            guestDetailsDao.deleteDetails(guestDetailsDto2.getGuest_name());
//            System.out.println("data successfully deleted");

            //read
        System.out.println("----------------read----------------");
        List<GuestDetailsDto> guestDetailsDtos=guestDetailsDao.readDetails();
          for (GuestDetailsDto ref:guestDetailsDtos)
          {
              System.out.println(ref);
              System.out.println("-------------------------------------------------------");
          }


        //batch insert
//        List<GuestDetailsDto> guestDetailsDtoList=new ArrayList<>();
//
//        GuestDetailsDto guestDetailsDto5=new GuestDetailsDto();
//        guestDetailsDto5.setGuest_name("ramanuja");
//        guestDetailsDto5.setAadhaarId(230567998779L);
//        guestDetailsDto5.setAddress("pune");
//        guestDetailsDto5.setWork("chef");
//        guestDetailsDto5.setDays_count(20);
//
//        GuestDetailsDto guestDetailsDto6=new GuestDetailsDto();
//        guestDetailsDto6.setGuest_name("anguru");
//        guestDetailsDto6.setAadhaarId(231567704778L);
//        guestDetailsDto6.setAddress("mumbai");
//        guestDetailsDto6.setWork("watchmen");
//        guestDetailsDto6.setDays_count(90);
//        guestDetailsDtoList.add(guestDetailsDto5);
//        guestDetailsDtoList.add(guestDetailsDto6);
//        guestDetailsService.validateBatchInsert(guestDetailsDtoList);
    }
}
