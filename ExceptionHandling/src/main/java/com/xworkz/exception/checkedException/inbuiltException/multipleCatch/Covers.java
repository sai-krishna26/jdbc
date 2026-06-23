package com.xworkz.exception.checkedException.inbuiltException.multipleCatch;

import java.sql.DriverManager;
import java.sql.SQLException;

public class Covers {
    public static void main(String[] args)
    {
        try
        {
            Class.forName("com.mysql.cj.jdbc.Driver");
            DriverManager.getConnection("mysql/homes_db","root","cat");
        }
        catch (ClassNotFoundException e) {
            System.err.println("class not found, class name: "+e.getClass()+"message: "+e.getMessage());
            //throw new RuntimeException(e);
        } catch (SQLException e) {
            System.err.println("invalid path, class name: "+e.getClass()+"message: "+e.getMessage());
            //throw new RuntimeException(e);
        }
    }

}
