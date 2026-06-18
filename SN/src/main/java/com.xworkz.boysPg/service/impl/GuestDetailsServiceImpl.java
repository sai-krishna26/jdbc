package com.xworkz.boysPg.service.impl;

import com.sun.deploy.security.SelectableSecurityManager;
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

    @Override
    public String validateBatchInsert(List<GuestDetailsDto> guestDetailsDtoList) {
        if(Objects.isNull(guestDetailsDao))
        {
            System.err.println("reference should not be null");
            return "Dao reference is null";
        }
        if(Objects.isNull(guestDetailsDtoList) ||guestDetailsDtoList.isEmpty())
        {
            System.err.println("list should not be null and empty");
            return "list should not be empty and null";
        }

        for (GuestDetailsDto dto:guestDetailsDtoList)
        {
            if (Objects.isNull(dto)) {
                System.out.println("reference should be non null");
                return "Dto is value is null";
            }
            if (dto.getGuest_name() == null || dto.getAadhaarId() < 100000000000L || dto.getAadhaarId() > 999999999999L || dto.getAddress() == null
                    || dto.getWork() == null || dto.getDays_count() < 1)
            {
                System.out.println("invalid data: " + dto);
                return "invalid data"+dto;
            }
        }
        guestDetailsDao.batchInsert(guestDetailsDtoList);
        return "done";
    }

}