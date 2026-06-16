package com.xworkz.boysPg.dao.Impl;

import com.xworkz.boysPg.dao.GuestDetailsDao;
import com.xworkz.boysPg.dto.GuestDetailsDto;

import java.sql.*;
import java.util.Objects;

public class GuestDetailsDaoImpl implements GuestDetailsDao {
    boolean check;
    int result;
    ResultSet rs;
    @Override
    public boolean insertDetails(GuestDetailsDto guestDetailsDto) {
        System.out.println("----------insert------------");
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        Connection connection = null;
        try {
            connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/snboys_db","root","root");
            PreparedStatement preparedStatement = connection.prepareStatement("insert into guest_info values(?,?,?,?,?)");
            preparedStatement.setString(1, guestDetailsDto.getGuest_name());
            preparedStatement.setLong(2, guestDetailsDto.getAadhaarId());
            preparedStatement.setString(3, guestDetailsDto.getAddress());
            preparedStatement.setString(4, guestDetailsDto.getWork());
            preparedStatement.setInt(5, guestDetailsDto.getDays_count());
            System.out.println("name: " + guestDetailsDto.getGuest_name() + "\ngender: " + guestDetailsDto.getAadhaarId() + "\nage: " + guestDetailsDto.getAddress() + "\ngroup_count: " + guestDetailsDto.getWork() + "\ncheckIn date: " + guestDetailsDto.getDays_count());
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
        return check;
    }

    @Override
    public int updateDetails(GuestDetailsDto guestDetailsDto) {
        System.out.println("----------update------------");
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        Connection connection = null;
        try {
            connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/snboys_db","root","root");
            PreparedStatement preparedStatement = connection.prepareStatement("update guest_info set days_count=? where guest_name=?");
            preparedStatement.setInt(1, guestDetailsDto.getDays_count());
            preparedStatement.setString(2, guestDetailsDto.getGuest_name());
            System.out.println("name: " + guestDetailsDto.getGuest_name() + "\ngroup_count: " + guestDetailsDto.getDays_count());
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

    @Override
    public int deleteDetails(GuestDetailsDto guestDetailsDto) {
        System.out.println("----------delete------------");
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        Connection connection = null;
        try {
            connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/snboys_db", "root", "root");
            PreparedStatement preparedStatement = connection.prepareStatement("delete from guest_info where guest_name=?");
            preparedStatement.setString(1, guestDetailsDto.getGuest_name());
            System.out.println("guest_name: " + guestDetailsDto.getGuest_name());
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

    @Override
    public void readDetails(GuestDetailsDto guestDetailsDto) {
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
            connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/snboys_db", "root", "root");
            PreparedStatement preparedStatement = connection.prepareStatement("select * from guest_info");
            rs= preparedStatement.executeQuery();
            while (rs.next())
            {
                System.out.println(rs.getString("guest_name"));
                System.out.println(rs.getLong("aadhaarId"));
                System.out.println(rs.getString("address"));
                System.out.println(rs.getString("work"));
                System.out.println(rs.getInt("days_count"));
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
            if (Objects.nonNull(rs)) {
                try {
                    rs.close();
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }
}
