package com.xworkz.patientdetails;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Objects;

public class GetPatientDetails {

    public static void main(String[] args) {

        System.out.println("checking GetPatientDetails class existence");

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("Driver Found");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

        String url = "jdbc:mysql://127.0.0.1:3306/payment_db";
        String user = "root";
        String password = "root";

        String sqlQuery =
                "INSERT INTO patient_history VALUES('Kiran','2026-2-4',4500.0,true,'2026-5-3')";

        Connection connect = null;
        Statement statement = null;

        try {
            connect = DriverManager.getConnection(url, user, password);

            statement = connect.createStatement();

            statement.execute(sqlQuery);

            System.out.println("Patient data inserted successfully");

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