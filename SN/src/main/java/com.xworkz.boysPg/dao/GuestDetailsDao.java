package com.xworkz.boysPg.dao;

import com.xworkz.boysPg.dto.GuestDetailsDto;

import java.util.List;

public interface GuestDetailsDao {
    public boolean insertDetails(GuestDetailsDto guestDetailsDto);
    public int updateDetails(int days_count,String guest_name);
    public int deleteDetails(String guest_name);
    public List<GuestDetailsDto> readDetails();
    public String batchInsert(List<GuestDetailsDto> guestDetailsDtoList);
}
