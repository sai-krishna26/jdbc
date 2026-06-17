package com.xworkz.homestay.Service;

import com.xworkz.homestay.dto.StoreCustomerDetailsDto;

import java.util.List;

public interface StoreCustomerDetailsService {
    public boolean validateStore(StoreCustomerDetailsDto storeCustomerDetailsDto);
    public int validateUpdate(String name, int group_count);
    public int validateDelete(int age);
    public void validateRead();
    public String ValidateBatchInsert(List<StoreCustomerDetailsDto> storeCustomerDetailsDtos);
}
