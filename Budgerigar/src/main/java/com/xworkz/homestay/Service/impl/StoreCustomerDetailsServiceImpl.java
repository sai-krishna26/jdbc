package com.xworkz.homestay.Service.impl;

import com.xworkz.homestay.Service.StoreCustomerDetailsService;
import com.xworkz.homestay.dao.StoreCustomerDetailsDao;
import com.xworkz.homestay.dto.StoreCustomerDetailsDto;
import lombok.AllArgsConstructor;

import java.util.Objects;
@AllArgsConstructor
public class StoreCustomerDetailsServiceImpl implements StoreCustomerDetailsService {

    StoreCustomerDetailsDao storeCustomerDetailsDao;
    @Override
    public boolean validateStore(StoreCustomerDetailsDto storeCustomerDetailsDto) {
        if(Objects.nonNull(storeCustomerDetailsDao) && storeCustomerDetailsDto.getName()!=null && storeCustomerDetailsDto.getGender()!=null && storeCustomerDetailsDto.getAge()>18 && storeCustomerDetailsDto.getGroup_count()>0 && storeCustomerDetailsDto.getCheckInDate()!=null)
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
    public void validateRead(String name) {
        if(Objects.nonNull(storeCustomerDetailsDao) && name!=null)
        {
            this.storeCustomerDetailsDao.read(name);
        }
        else
        {
            System.err.println("name should not be null");
        }
    }
}
