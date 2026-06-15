package com.xworkkz.taxi.dao.impl;

import com.xworkkz.taxi.dao.TaxiDetailsDao;
import com.xworkkz.taxi.dto.TaxiDetailsDto;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class TaxiDetailsDaoImpl implements TaxiDetailsDao {
    int inserted;
    @Override
    public int insertTaxiDetails(TaxiDetailsDto taxiDetailsDto) {
        System.out.println("-----------read--------------");
        //inserting table rows with executeUpdate method.
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        Connection connection=null;
        try {
            connection=DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/uber_db","root","root");
            PreparedStatement preparedStatement=connection.prepareStatement("INSERT INTO trip_details(driver_name, car_name, license, total_passengers) VALUES(?,?,?,?)");
            preparedStatement.setString(1,taxiDetailsDto.getDriverName());
            preparedStatement.setString(2,taxiDetailsDto.getCarName());
            preparedStatement.setInt(4,taxiDetailsDto.getPassengerCount());
            preparedStatement.setString(3,taxiDetailsDto.getLicense());
            inserted=preparedStatement.executeUpdate();
            System.out.println("inserted? "+inserted);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return inserted;
    }

    public int readTaxiDetails() {
        //trying to read with executeUpdate method.
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        Connection connection=null;
        try {
            connection=DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/uber_db","root","root");
            PreparedStatement preparedStatement=connection.prepareStatement("select * from trip_details");
            inserted=preparedStatement.executeUpdate();
            System.out.println("got details? "+inserted);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return inserted;
    }
}
