package com.xworkz.exception.checkedException.inbuiltException.multiCatch;

import com.mysql.cj.jdbc.Driver;

import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Slip {
    public static void main(String[] args) {
        Connection connection=null;
        try
        {
            File file=new File("c/gov/text.txt");
            file.createNewFile();
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection=DriverManager.getConnection("google.com/database","root","bat");
            connection.close();
        } catch (ClassNotFoundException | SQLException | IOException e) {
            System.err.println("invalid query or invalid method! in class: "+e.getClass()+" message:"+e.getMessage());
        }

        int sum=8+456;
        System.out.println("sum:"+sum);
    }
}
