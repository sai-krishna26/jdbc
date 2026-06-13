package com.xworkz.homestay.dao;

import com.xworkz.homestay.dto.StoreCustomerDetailsDto;

public interface StoreCustomerDetailsDao{
    public boolean store(StoreCustomerDetailsDto storeCustomerDetailsDto);
    public int update(StoreCustomerDetailsDto storeCustomerDetailsDto);
    public int delete(StoreCustomerDetailsDto storeCustomerDetailsDto);
    public void read(StoreCustomerDetailsDto storeCustomerDetailsDto);
}
