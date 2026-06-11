package com.xworkz.patientdetails;

import java.sql.*;
import java.util.Objects;

public class ReadPatientsDetails {
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
            connection=DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/hospital_db","root","root");
            statement=connection.createStatement();
            resultSet=statement.executeQuery("select * from patients_info");

            while(resultSet.next())
            {
                System.out.println(resultSet.getString("patient_name"));
                System.out.println(resultSet.getString("case_name"));
                System.out.println(resultSet.getInt("token_no"));
                System.out.println(resultSet.getDate("arrival_date"));
                System.out.println(resultSet.getDouble("fee"));
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
