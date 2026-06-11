package com.xworkz.cafeDetails;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Objects;

public class UpdateCafeDetails {
    public static void main(String[] args) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

        String url = "jdbc:mysql://127.0.0.1:3306/cafe_db";
        String user = "root";
        String password = "root";
        String sqlQuery = "UPDATE cafe_details SET coffee_prize=20 WHERE address='gurumatkal'";

        Connection connect = null;
        Statement statement = null;

        try {
            connect = DriverManager.getConnection(url, user, password);

            statement = connect.createStatement();

            int check=statement.executeUpdate(sqlQuery);
            System.out.println("cafe details updated? :"+check);

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
