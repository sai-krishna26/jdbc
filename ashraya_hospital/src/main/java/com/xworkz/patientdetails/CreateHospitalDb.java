package com.xworkz.patientdetails;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Objects;

public class CreateHospitalDb {
    public static void main(String[] args) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        String url = "jdbc:mysql://127.0.0.1:3306/hospital_db";
        String user = "root";
        String password = "root";

        String sqlQuery ="create table patients_info(patient_name varchar(20),case_name varchar(20), token_no int, arrival_date date, fee double)";
        Connection connect = null;
        Statement statement = null;
        try {
            connect = DriverManager.getConnection(url, user, password);
            statement = connect.createStatement();
            boolean result= statement.execute(sqlQuery);
            System.out.println("result of table creation: "+result);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            if (Objects.nonNull(statement)) {
                try {
                    statement.close();
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
            }
            if (Objects.nonNull(connect)) {
                try {
                    connect.close();
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }
}
