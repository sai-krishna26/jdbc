package com.xworkz.cafeDetails;

import java.sql.*;
import java.util.Objects;

public class ReadCafeDetails {
    public static void main(String[] args) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        Connection connection=null;
        Statement statement=null;
        ResultSet resultSet=null;
        try {
            connection= DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/cafe_db","root","root");
            statement=connection.createStatement();
            resultSet=statement.executeQuery("select * from cafe_details");

            while(resultSet.next())
            {
                System.out.println(resultSet.getString("cafe_name"));
                System.out.println(resultSet.getString("address"));
                System.out.println(resultSet.getDouble("coffee_prize"));
                System.out.println(resultSet.getString("special_coffee"));
                System.out.println("-----------------------------------");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        finally {
            if (Objects.nonNull(connection))
            {
                try {
                    connection.close();
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
            }

            if (Objects.nonNull(statement))
            {
                try {
                    statement.close();
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
            }

            if(Objects.nonNull(resultSet))
            {
                try {
                    resultSet.close();
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }
}
