package com.xworkz.transDetail.recieverDeatails;

import javax.swing.plaf.nimbus.State;
import java.sql.*;
import java.util.Objects;

public class GetReceiverDetails
{
    public static void main(String[] args) {
        System.out.println("checking the GetReceiverDetails class existence");
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("GetReceiverDetails is found!!");
        }
        catch(ClassNotFoundException e)
        {
            throw new RuntimeException(e);
        }

        Connection connection=null;
        Statement statement=null;
        String query="select * from patient_history";
        ResultSet resultSet=null;
        try {
            connection=DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/payment_db","root","root");
            statement=connection.createStatement();
            resultSet=statement.executeQuery(query);

            while (resultSet.next())
            {
                System.out.println(resultSet.getString("patient_name"));
                System.out.println(resultSet.getDate("admition_date"));
                System.out.println(resultSet.getFloat("amount"));
                System.out.println(resultSet.getBoolean("payment_status"));
                System.out.println(resultSet.getDate("dischagre_date"));
                System.out.println("-------------------------------------------------------");

            }
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
            if (Objects.nonNull(statement))
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
