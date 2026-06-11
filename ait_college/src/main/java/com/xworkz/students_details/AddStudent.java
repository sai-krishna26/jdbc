package com.xworkz.students_details;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Objects;

public class AddStudent{

        public static void main(String[] args) {
            try {
                Class.forName("com.mysql.cj.jdbc.Driver");
            } catch (ClassNotFoundException e) {
                throw new RuntimeException(e);
            }

            String url = "jdbc:mysql://127.0.0.1:3306/college_db";
            String user = "root";
            String password = "root";

            String sqlQuery =
                    "INSERT INTO students_info VALUES"+"('Saikrishna','CSE',2026,5,'pass'),"+
                            "('Bharath','ISE',2026,6,'fail'),"+"('laxman','ECE',2025,8,'fail')";

            Connection connect = null;
            Statement statement = null;

            try {
                connect = DriverManager.getConnection(url, user, password);

                statement = connect.createStatement();

                boolean check=statement.execute(sqlQuery);

                System.out.println("Students data inserted? :"+check);

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
