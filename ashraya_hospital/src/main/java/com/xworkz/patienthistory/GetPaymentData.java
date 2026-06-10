package com.xworkz.patienthistory;

import com.mysql.cj.jdbc.Driver;
import com.sun.xml.internal.ws.api.model.wsdl.WSDLOutput;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Objects;

public class GetPaymentData {
    public static void main(String[] args) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

        String url="jdbc:mysql://127.0.0.1:3306/payment_db";
        String username="root";
        String password="root";
        String sqlQuery="insert into patient_history values('vishnu','2026-3-5',12000.98,true,'2026-4-10')";
        Connection connect=null;
        Statement statement=null;

        try {
            connect=DriverManager.getConnection(url,username,password);
            System.out.println("connection is established");
            statement=connect.createStatement();
            statement.execute(sqlQuery);
            System.out.println("value is successfully loaded to DB");
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
        System.out.println("closed the connection");
    }
}
