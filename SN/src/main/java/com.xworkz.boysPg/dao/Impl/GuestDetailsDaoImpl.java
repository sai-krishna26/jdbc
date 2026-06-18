package com.xworkz.boysPg.dao.Impl;

import com.xworkz.boysPg.dao.GuestDetailsDao;
import com.xworkz.boysPg.dto.GuestDetailsDto;

import java.sql.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
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
    public int updateDetails(int days_count,String guest_name) {
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
            preparedStatement.setInt(1,days_count);
            preparedStatement.setString(2,guest_name);
            System.out.println("name: " + guest_name + "\ngroup_count: " +days_count);
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
    public int deleteDetails(String guest_name) {
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
            preparedStatement.setString(1,guest_name);
            System.out.println("guest_name: " +guest_name);
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
    public List<GuestDetailsDto> readDetails() {
        List<GuestDetailsDto> ar=new ArrayList<>();
        //System.out.println("----------read-----------");
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
                GuestDetailsDto guestDetailsDto=new GuestDetailsDto();
                guestDetailsDto.setGuest_name(rs.getString("guest_name"));
                guestDetailsDto.setAadhaarId(rs.getLong("aadhaarId"));
                guestDetailsDto.setAddress(rs.getString("address"));
                guestDetailsDto.setWork(rs.getString("work"));
                guestDetailsDto.setDays_count(rs.getInt("days_count"));
                ar.add(guestDetailsDto);

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
        return ar;
    }

    @Override
    public String batchInsert(List<GuestDetailsDto> guestDetailsDtoList) {
        Connection connection=null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection=DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/snboys_db","root","root");
            PreparedStatement preparedStatement=connection.prepareStatement("insert into guest_info values(?,?,?,?,?)");
            for (GuestDetailsDto dto:guestDetailsDtoList)
            {
                preparedStatement.setString(1,dto.getGuest_name());
                preparedStatement.setLong(2,dto.getAadhaarId());
                preparedStatement.setString(3,dto.getAddress());
                preparedStatement.setString(4, dto.getWork());
                preparedStatement.setInt(5,dto.getDays_count());

                preparedStatement.addBatch();
            }
            int[] values=preparedStatement.executeBatch();
            System.out.println("batch inserted: "+ Arrays.toString(values));
            System.out.println("batch details are inserted successfully");
        } catch (ClassNotFoundException | SQLException e) {
            throw new RuntimeException(e);
        }

        return "";
    }
}
