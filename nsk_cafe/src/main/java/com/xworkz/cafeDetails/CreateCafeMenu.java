package com.xworkz.cafeDetails;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Objects;

public class CreateCafeMenu {
    public static void main(String[] args) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        Connection connection=null;
        Statement statement=null;
        try {
            connection=DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/cafe_db","root","root");
            statement=connection.createStatement();
            boolean check=statement.execute("create table cafe_details(cafe_name varchar(20), address varchar(20), coffee_prize double, special_coffee varchar(20))");
            System.out.println("result of table creation: "+check);
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
            if(Objects.nonNull(statement))
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
