package com.xworkz.patientdetails;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Objects;

public class AddPatients{

    public static void main(String[] args) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

        String url = "jdbc:mysql://127.0.0.1:3306/hospital_db";
        String user = "root";
        String password = "root";

        String sqlQuery =
                "INSERT INTO patients_info VALUES"+"('Kiran','cancer',45,'2024-5-3',5000),"+"('charan','diabetis',12,'2024-5-3',3500),"+"('pavan','rabis',16,'2024-5-3',4000)";
        Connection connect = null;
        Statement statement = null;

        try {
            connect = DriverManager.getConnection(url, user, password);
            statement = connect.createStatement();
            boolean check=statement.execute(sqlQuery);
            System.out.println("Patient data inserted?: "+check);

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