package com.xworkz.homestay.dao.impl;

import com.xworkz.homestay.dao.StoreCustomerDetailsDao;
import com.xworkz.homestay.dto.StoreCustomerDetailsDto;

import javax.imageio.plugins.jpeg.JPEGImageReadParam;
import java.sql.*;
import java.util.Objects;

public class StoreCustomerDetailsDaoImpl implements StoreCustomerDetailsDao {
    boolean check = false;
    int result = 0;
    ResultSet set = null;

    @Override
    public boolean store(StoreCustomerDetailsDto storeCustomerDetailsDto) {
        System.out.println("----------insert------------");
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        Connection connection = null;
        try {
            connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/Budgerigar_db", "root", "root");
            PreparedStatement preparedStatement = connection.prepareStatement("insert into homes_info values(?,?,?,?,?)");
            preparedStatement.setString(1, storeCustomerDetailsDto.getName());
            preparedStatement.setString(2, storeCustomerDetailsDto.getGender());
            preparedStatement.setInt(3, storeCustomerDetailsDto.getAge());
            preparedStatement.setInt(4, storeCustomerDetailsDto.getGroup_count());
            preparedStatement.setDate(5, Date.valueOf(storeCustomerDetailsDto.getCheckInDate()));
            System.out.println("name: " + storeCustomerDetailsDto.getName() + "\ngender: " + storeCustomerDetailsDto.getGender() + "\nage: " + storeCustomerDetailsDto.getAge() + "\ngroup_count: " + storeCustomerDetailsDto.getGroup_count() + "\ncheckIn date: " + storeCustomerDetailsDto.getCheckInDate());
            check = preparedStatement.execute();
            System.out.println("inserted?: " + check);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            if (Objects.nonNull(connection)) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
            }
        }
        return false;
    }

    public int update(StoreCustomerDetailsDto storeCustomerDetailsDto) {
        System.out.println("----------update------------");
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        Connection connection = null;
        try {
            connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/Budgerigar_db", "root", "root");
            PreparedStatement preparedStatement = connection.prepareStatement("update homes_info set group_count=? where name=?");
            preparedStatement.setString(2, storeCustomerDetailsDto.getName());
            preparedStatement.setInt(1, storeCustomerDetailsDto.getGroup_count());
            System.out.println("name: " + storeCustomerDetailsDto.getName() + "\ngroup_count: " + storeCustomerDetailsDto.getGroup_count());
            result = preparedStatement.executeUpdate();
            System.out.println(result + " row(s) updated");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            if (Objects.nonNull(connection)) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
            }
        }

        return result;
    }

    public int delete(StoreCustomerDetailsDto storeCustomerDetailsDto) {
        System.out.println("----------delete------------");
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        Connection connection = null;
        try {
            connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/Budgerigar_db", "root", "root");
            PreparedStatement preparedStatement = connection.prepareStatement("delete from homes_info where age>?");
            preparedStatement.setInt(1, storeCustomerDetailsDto.getAge());
            System.out.println("Age: " + storeCustomerDetailsDto.getAge());
            result = preparedStatement.executeUpdate();
            System.out.println(result + " row(s) deleted");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            if (Objects.nonNull(connection)) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
            }
        }

        return result;
    }

    public void read(StoreCustomerDetailsDto storeCustomerDetailsDto)
    {
        System.out.println("----------read-----------");
        try
        {
            Class.forName("com.mysql.cj.jdbc.Driver");
        }
        catch (ClassNotFoundException e)
        {
            throw new RuntimeException(e);
        }

        Connection connection = null;
        try
        {
            connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/Budgerigar_db", "root", "root");
            PreparedStatement preparedStatement = connection.prepareStatement("select * from homes_info where name=?");
            preparedStatement.setString(1, storeCustomerDetailsDto.getName());
            set = preparedStatement.executeQuery();
            while (set.next())
            {
                System.out.println(set.getString("name"));
                System.out.println(set.getString("gender"));
                System.out.println(set.getInt("age"));
                System.out.println(set.getInt("group_count"));
                System.out.println(set.getDate("date"));
                System.out.println("-----------------------------------");
            }
        }
        catch (SQLException e) {
            throw new RuntimeException(e);
        }
        finally
        {
            if (Objects.nonNull(connection))
            {
                try {
                    connection.close();
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
            }
            if (Objects.nonNull(set)) {
                try {
                    set.close();
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }
}
