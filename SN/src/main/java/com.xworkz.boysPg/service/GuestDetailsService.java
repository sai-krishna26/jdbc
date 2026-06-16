package com.xworkz.boysPg.service;

import com.xworkz.boysPg.dto.GuestDetailsDto;

import java.util.List;

public interface GuestDetailsService {
    public boolean validateInsertDetails(GuestDetailsDto guestDetailsDto);
    public int validateUpdateDetails(int days_count,String guest_name);
    public int validateDeleteDetails(String guest_name);
    public List<GuestDetailsDto> validateReadDetails();
}
