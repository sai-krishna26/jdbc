//step1:loading dependencies
package com.xworkz.transDetail.PaymentStatus;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Objects;

public class GetPaymentStatus{
    public static void main(String[] args) {
        System.out.println("checking GetPaymentStatus class existence");
        //step2:checking class existence
        try
        {
            Class.forName("com.xworkz.transDetail.statementDetails.GetStatementDetails");
            System.out.println("GetPaymentStatus is found!!");
        }
        catch(ClassNotFoundException e)
        {
            throw new RuntimeException(e);
        }


        //step3:connection building
        String url="jdbc:mysql://127.0.0.1:3306/transaction_db";
        String user="root";
        String password="root";
        String sqlQuery="INSERT INTO payments VALUES('online','sbi bank','UBIN07653',6000.04,false)";
        Connection connect=null;
        Statement statement=null;

        try {
           connect=DriverManager.getConnection(url,user,password);
        //step4:creating statement
            statement=connect.createStatement();


            //step5:execute the query
            statement.execute(sqlQuery);
            System.out.println("data is successfully inserted");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        finally {
            //step6:close connection
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
}
