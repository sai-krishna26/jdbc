package com.xworkz.students_details.createDb;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Objects;

public class CreateStudentsDb {
    public static void main(String[] args) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        String url = "jdbc:mysql://127.0.0.1:3306/college_db";
        String user = "root";
        String password = "root";

        String sqlQuery ="create table students_info(student_name varchar(20),dept varchar(20), batch int, class int, result varchar(20))";
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
