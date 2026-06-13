package com.xworkz.homestay.dao.impl;

import com.xworkz.homestay.dao.StoreCustomerDetailsDao;
import com.xworkz.homestay.dto.StoreCustomerDetailsDto;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class StoreCustomerDetailsDaoImpl implements StoreCustomerDetailsDao {
    @Override
    public boolean store(StoreCustomerDetailsDto storeCustomerDetailsDto) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        Connection connection=null;
        try {
            connection=DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/Budgerigar_db","root","root");
            PreparedStatement preparedStatement=connection.prepareStatement("insert into homes_info values('krishna','male',23,4,'2026-06-13')");

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return false;
    }
}
