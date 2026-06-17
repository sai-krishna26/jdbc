package com.xworkkz.taxi.dao;

import com.xworkkz.taxi.dto.TaxiDetailsDto;

public interface TaxiDetailsDao {
    public int List(TaxiDetailsDto taxiDetailsDto);
    public int readTaxiDetails();
}
