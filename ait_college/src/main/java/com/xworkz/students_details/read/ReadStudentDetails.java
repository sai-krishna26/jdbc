package com.xworkz.students_details.read;

import java.sql.*;
import java.util.Objects;

public class ReadStudentDetails {
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
            connection=DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/college_db","root","root");
            statement=connection.createStatement();
            resultSet=statement.executeQuery("SELECT * FROM students_info");

            while(resultSet.next())
            {
                System.out.println(resultSet.getString("student_name"));
                System.out.println(resultSet.getString("dept"));
                System.out.println(resultSet.getInt("batch"));
                System.out.println(resultSet.getInt("class"));
                System.out.println(resultSet.getString("result"));
                System.out.println("--------------------------------------------");
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
