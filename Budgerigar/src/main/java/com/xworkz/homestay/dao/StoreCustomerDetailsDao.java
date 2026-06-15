package com.xworkz.homestay.dao;

import com.xworkz.homestay.dto.StoreCustomerDetailsDto;

public interface StoreCustomerDetailsDao{
    public boolean store(StoreCustomerDetailsDto storeCustomerDetailsDto);
    public int update(String name, int group_count);
    public int delete(int age);
    public void read(String name);
}
