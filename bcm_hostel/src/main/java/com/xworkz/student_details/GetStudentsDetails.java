package com.xworkz.student_details;

import javax.swing.plaf.nimbus.State;
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
        String url="jdbc:mysql://127.0.0.1:3306/students_db";
        String user="root";
        String password="root";
        String sql="insert into students_details values('praveen','2022-6-5',10,true,'2026-4-10')";
        Connection connection=null;
        Statement statement=null;

        try {
            connection=DriverManager.getConnection(url,user,password);
            statement=connection.createStatement();
            statement.execute(sql);
            System.out.println("values is stored in database");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

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
