package com.xworkz.students_details;

import com.mysql.cj.jdbc.Driver;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Objects;

public class GetStudentsDetails {
    public static void main(String[] args) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

        String url="jdbc:mysql://127.0.0.1:3306/college_db";
        String name="root";
        String pass="root";
        String query="INSERT INTO students_details VALUES " +
                "('kiran','2022-06-05','cse',true,'pass')," +
                "('sharan','2022-05-02','ece',false,'fail')";
        Connection connect=null;
        Statement statement=null;
        try {
            connect=DriverManager.getConnection(url,name,pass);
            statement=connect.createStatement();
            statement.execute(query);
            System.out.println("value is loaded into database");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        if(Objects.nonNull(connect))
        {
            try {
                connect.close();
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
