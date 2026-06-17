package com.xworkz.boysPg.runner;

import com.xworkz.boysPg.dao.GuestDetailsDao;
import com.xworkz.boysPg.dao.Impl.GuestDetailsDaoImpl;
import com.xworkz.boysPg.dto.GuestDetailsDto;

import java.util.ArrayList;
import java.util.List;

public class BoysPgRunner {
    public static void main(String[] args)
    {
            //insert
        GuestDetailsDao guestDetailsDao=new GuestDetailsDaoImpl();
        GuestDetailsDto guestDetailsDto=new GuestDetailsDto();
        guestDetailsDto.setGuest_name(null);
        guestDetailsDto.setAadhaarId();
        guestDetailsDto.setAddress("anantnagar");
        guestDetailsDto.setWork("manager");
        guestDetailsDto.setDays_count(30);

        boolean check=guestDetailsDao.insertDetails(guestDetailsDto);
        System.out.println("data inserted succesfully");

            //update
//            GuestDetailsDto guestDetailsDto1=new GuestDetailsDto();
//            guestDetailsDto1.setDays_count(15);
//            guestDetailsDto1.setGuest_name("pratheek");
//            guestDetailsDao.updateDetails(guestDetailsDto1.getDays_count(), guestDetailsDto1.getGuest_name());
//            System.out.println("data updated successfully");

//            //delete
//            GuestDetailsDto guestDetailsDto2=new GuestDetailsDto();
//            guestDetailsDto2.setGuest_name("pratheek");
//            guestDetailsDao.deleteDetails(guestDetailsDto2.getGuest_name());
//            System.out.println("data successfully deleted");

            //read
//        System.out.println("----------------read----------------");
//        List<GuestDetailsDto> guestDetailsDtos=guestDetailsDao.readDetails();
//          for (GuestDetailsDto ref:guestDetailsDtos)
//          {
//              System.out.println(ref);
//              System.out.println("-------------------------------------------------------");
//          }
    }
}
