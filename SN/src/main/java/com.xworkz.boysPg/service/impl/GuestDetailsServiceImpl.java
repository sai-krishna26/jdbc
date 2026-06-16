package com.xworkz.boysPg.service.impl;

import com.xworkz.boysPg.dao.GuestDetailsDao;
import com.xworkz.boysPg.dto.GuestDetailsDto;
import com.xworkz.boysPg.service.GuestDetailsService;

import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class GuestDetailsServiceImpl implements GuestDetailsService {
    GuestDetailsDao guestDetailsDao;
    public GuestDetailsServiceImpl(GuestDetailsDao guestDetailsDao)
    {
        this.guestDetailsDao=guestDetailsDao;
    }
    @Override
    public boolean validateInsertDetails(GuestDetailsDto guestDetailsDto)
    {
        if (Objects.nonNull(guestDetailsDao) && guestDetailsDto.getGuest_name()!=null && guestDetailsDto.getAadhaarId()>100000000000L && guestDetailsDto.getAadhaarId()<999999999999L && guestDetailsDto.getAddress()!=null && guestDetailsDto.getWork()!=null && guestDetailsDto.getDays_count()>1)
        {
            return this.guestDetailsDao.insertDetails(guestDetailsDto);
        }
        else
        {
            System.err.println("insert:check your data once again (avoid null)");
        }
        return false;
    }

    @Override
    public int validateUpdateDetails(int days_count, String guest_name) {
        if(Objects.nonNull(guestDetailsDao) && days_count>1 && guest_name!=null)
        {
            return this.guestDetailsDao.updateDetails(days_count,guest_name);
        }
        else
        {
            System.err.println("update:check your data once again (avoid null)");
        }
        return 0;
    }

    @Override
    public int validateDeleteDetails(String guest_name)
    {
        if (Objects.nonNull(guestDetailsDao) && guest_name!=null)
        {
            this.guestDetailsDao.deleteDetails(guest_name);
        }
        else
        {
            System.err.println("delete:check your data once again (avoid null)");
        }
        return 0;
    }

    @Override
    public List<GuestDetailsDto> validateReadDetails() {
        if(Objects.nonNull(guestDetailsDao))
        {
            this.guestDetailsDao.readDetails();
        }
        System.err.println("read:guestDetailsDao should not be null");
        return Collections.emptyList();
    }
}
