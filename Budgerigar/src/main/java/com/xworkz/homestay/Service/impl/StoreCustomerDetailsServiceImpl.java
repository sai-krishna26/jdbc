package com.xworkz.homestay.Service.impl;

import com.xworkz.homestay.Service.StoreCustomerDetailsService;
import com.xworkz.homestay.dao.StoreCustomerDetailsDao;
import com.xworkz.homestay.dto.StoreCustomerDetailsDto;

import java.sql.Date;
import java.util.List;
import java.util.Objects;
public class StoreCustomerDetailsServiceImpl implements StoreCustomerDetailsService {
    StoreCustomerDetailsDao storeCustomerDetailsDao;
    StoreCustomerDetailsDto storeCustomerDetailsDto;
    public StoreCustomerDetailsServiceImpl(StoreCustomerDetailsDao storeCustomerDetailsDao)
    {
        this.storeCustomerDetailsDao=storeCustomerDetailsDao;
    }
    @Override
    public boolean validateStore(StoreCustomerDetailsDto storeCustomerDetailsDto) {
        if(Objects.nonNull(storeCustomerDetailsDao) && storeCustomerDetailsDto.getName()!=null && storeCustomerDetailsDto.getGender()!=null && storeCustomerDetailsDto.getAge()>18 && storeCustomerDetailsDto.getGroup_count()>0 && storeCustomerDetailsDto.getDate()!=null)
        {
            return this.storeCustomerDetailsDao.store(storeCustomerDetailsDto);
        }
        else
        {
            System.err.println("reference should not be null && details should be valid");
        }
        return false;
    }

    @Override
    public int validateUpdate(String name, int group_count) {
        if(Objects.nonNull(storeCustomerDetailsDao) && name!=null && group_count>0)
        {
            return this.storeCustomerDetailsDao.update(name,group_count);
        }
        else
        {
            System.err.println("name and group_count should be valid");
        }
        return 0;
    }

    @Override
    public int validateDelete(int age) {
        if(Objects.nonNull(storeCustomerDetailsDao) && age>18)
        {
            return this.storeCustomerDetailsDao.delete(age);
        }
        else
        {
            System.out.println("age should be valid");
        }
        return 0;
    }

    @Override
    public void validateRead() {
        if(Objects.nonNull(storeCustomerDetailsDao))
        {
            this.storeCustomerDetailsDao.read();
        }
        else
        {
            System.err.println("name should not be null");
        }
    }

    @Override
    public String ValidateBatchInsert(List<StoreCustomerDetailsDto> storeCustomerDetailsDtos) {
        if(Objects.isNull(storeCustomerDetailsDao) && Objects.isNull(storeCustomerDetailsDtos) && storeCustomerDetailsDtos.isEmpty())
        {
            System.err.println("dao and list should not be null and empty");
        }

        for(StoreCustomerDetailsDto dto:storeCustomerDetailsDtos)
        {
            if(Objects.isNull(dto))
            {
                System.out.println("Dto is value is null");
                return "Dto is value is null";
            }

            if(dto.getName()==null || dto.getGender()==null || dto.getAge()<18 || dto.getGroup_count()<1 || dto.getDate()==null)
            {
                System.out.println("invalid data:"+dto);
                return "invalid data:"+dto;
            }
        }

        this.storeCustomerDetailsDao.batchInsert(storeCustomerDetailsDtos);
        return "batch insert is successful";
    }
}