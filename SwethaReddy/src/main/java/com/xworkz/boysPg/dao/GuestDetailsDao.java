package com.xworkz.boysPg.dao;

import com.xworkz.boysPg.dto.GuestDetailsDto;

public interface GuestDetailsDao {
    public boolean insertDetails(GuestDetailsDto guestDetailsDto);
    public int updateDetails(GuestDetailsDto guestDetailsDto);
    public int deleteDetails(GuestDetailsDto guestDetailsDto);
    public void readDetails(GuestDetailsDto guestDetailsDto);
}
