package com.xworkz.boysPg.runner;

import com.xworkz.boysPg.dao.GuestDetailsDao;
import com.xworkz.boysPg.dao.Impl.GuestDetailsDaoImpl;
import com.xworkz.boysPg.dto.GuestDetailsDto;

public class BoysPgRunner {
    public static void main(String[] args) {
            //insert
            GuestDetailsDao guestDetailsDao=new GuestDetailsDaoImpl();
//            GuestDetailsDto guestDetailsDto=new GuestDetailsDto();
//            guestDetailsDto.setGuest_name("tarun");
//            guestDetailsDto.setAadhaarId(123412349988L);
//            guestDetailsDto.setAddress("mudigeri");
//            guestDetailsDto.setWork("employee");
//            guestDetailsDto.setDays_count(90);
//
//            boolean check=guestDetailsDao.insertDetails(guestDetailsDto);
//            System.out.println("data inserted succesfully");

//            //update
//            GuestDetailsDto guestDetailsDto1=new GuestDetailsDto();
//            guestDetailsDto1.setDays_count(60);
//            guestDetailsDto1.setGuest_name("kiran");
//            guestDetailsDao.updateDetails(guestDetailsDto1);
//            System.out.println("data updated successfully");

//            //delete
//            GuestDetailsDto guestDetailsDto2=new GuestDetailsDto();
//            guestDetailsDto2.setGuest_name("tarun");
//            guestDetailsDao.deleteDetails(guestDetailsDto2);
//            System.out.println("data successfully deleted");

            //read
            GuestDetailsDto guestDetailsDto3=new GuestDetailsDto();
            guestDetailsDto3.setAadhaarId(123412344321L);
            guestDetailsDao.readDetails(guestDetailsDto3);
        }
}
