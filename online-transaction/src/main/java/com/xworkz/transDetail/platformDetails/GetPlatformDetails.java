package com.xworkz.transDetail.platformDetails;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Objects;

public class GetPlatformDetails {
    public static void main(String[] args) {
        System.out.println("checking the GetPlatformDetails class existence");
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("GetPlatformDetails is found!!");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        Connection connection=null;
        Statement statement=null;
        try {
           connection=DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/payment_db","root","root");
           statement=connection.createStatement();
           int check=statement.executeUpdate("INSERT INTO patient_history(patient_name, admition_date, amount, payment_status) VALUES('traabhi','2024-6-5',1000.98,true)");
            System.out.println("result of update: "+check);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        finally {
            if(Objects.nonNull(connection))
            {
                try {
                    connection.close();
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
            }
            if(statement!=null)
            {
                try {
                    statement.close();
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }
}

