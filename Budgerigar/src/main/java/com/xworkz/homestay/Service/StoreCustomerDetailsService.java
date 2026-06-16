package com.xworkz.homestay.Service;

import com.xworkz.homestay.dto.StoreCustomerDetailsDto;

public interface StoreCustomerDetailsService {
    public boolean validateStore(StoreCustomerDetailsDto storeCustomerDetailsDto);
    public int validateUpdate(String name, int group_count);
    public int validateDelete(int age);
    public void validateRead();
}
