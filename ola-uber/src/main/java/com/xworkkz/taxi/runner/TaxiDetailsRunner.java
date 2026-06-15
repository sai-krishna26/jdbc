package com.xworkkz.taxi.runner;

import com.xworkkz.taxi.dao.TaxiDetailsDao;
import com.xworkkz.taxi.dao.impl.TaxiDetailsDaoImpl;
import com.xworkkz.taxi.dto.TaxiDetailsDto;

public class TaxiDetailsRunner {
    public static void main(String[] args) {
        TaxiDetailsDao taxiDetailsDao=new TaxiDetailsDaoImpl();
        TaxiDetailsDto taxiDetailsDto=new TaxiDetailsDto();
        int count=taxiDetailsDao.readTaxiDetails();
        System.out.println("count:"+count);
    }
}
