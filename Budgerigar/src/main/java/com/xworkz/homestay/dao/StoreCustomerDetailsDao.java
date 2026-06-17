package com.xworkz.homestay.dao;

import com.xworkz.homestay.dto.StoreCustomerDetailsDto;

import java.util.List;

public interface StoreCustomerDetailsDao{
    public boolean store(StoreCustomerDetailsDto storeCustomerDetailsDto);
    public int update(String name, int group_count);
    public int delete(int age);
    public List<StoreCustomerDetailsDto> read();
    public String batchInsert(List<StoreCustomerDetailsDto> storeCustomerDetailsDtos);
}
