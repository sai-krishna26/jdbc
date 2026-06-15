package com.xworkz.WaterBottle.dao.impl;

import com.mysql.cj.xdevapi.PreparableStatement;
import com.xworkz.WaterBottle.dao.WaterBottleDetailsDao;
import com.xworkz.WaterBottle.dto.WaterBottleDetailsDto;

import javax.jws.Oneway;
import java.sql.*;
import java.util.Objects;

public class WaterBottleDetailsDaoImpl implements WaterBottleDetailsDao
{
    int result = 0;
    boolean save = false;
    ResultSet set = null;

    @Override
    public boolean saveDetails(WaterBottleDetailsDto waterBottleDetailsDto)
    {
        if (Objects.nonNull(waterBottleDetailsDto)) {
            System.out.println("started process...just chill!!");
            try {
                Class.forName("com.mysql.cj.jdbc.Driver");
            } catch (ClassNotFoundException e) {
                throw new RuntimeException(e);
            }
            Connection connection = null;

            try {
                connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/Kingfisher_db", "root", "root");
                PreparedStatement prepareStatement = connection.prepareStatement("insert into water_bottle(name,size,cost,validity,is_certified) values(?,?,?,?,?)");
                prepareStatement.setString(1, waterBottleDetailsDto.getName());
                prepareStatement.setFloat(2, waterBottleDetailsDto.getSize());
                prepareStatement.setDouble(3, waterBottleDetailsDto.getCost());
                prepareStatement.setString(4, waterBottleDetailsDto.getValidity());
                prepareStatement.setBoolean(5, waterBottleDetailsDto.isCertified());
                System.out.println("inserted placeholders!... wait for original details!");
                boolean check = prepareStatement.execute();
                save = check;
                System.out.println("inserted?: "+save+" (bcz of .execute)");
                System.out.println("details are successfully inserted");
            } catch (SQLException e) {
                throw new RuntimeException(e);
            } finally {
                if (Objects.nonNull(connection))
                    try {
                        connection.close();
                    } catch (SQLException e) {
                        throw new RuntimeException(e);
                    }
            }
        }
        return save;
    }

    public int updateDetails(String name, Double cost)
    {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

        Connection connect = null;
        try {
            connect = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/Kingfisher_db", "root", "root");
            PreparedStatement preparedStatement = connect.prepareStatement("update water_bottle set cost=? where name=?");
            preparedStatement.setDouble(1,cost);
            preparedStatement.setString(2, name);
            System.out.println("searching to update!... wait for result!");
            System.out.println("Name = " + name);
            System.out.println("Cost = " + cost);
            result = preparedStatement.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            if (Objects.nonNull(connect)) {
                try {
                    connect.close();
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
            }
        }
        return result;
    }

    public int deleteDetails(String name)
    {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

        Connection connect = null;
        try {
            connect = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/Kingfisher_db", "root", "root");
            PreparedStatement preparedStatement = connect.prepareStatement("DELETE FROM water_bottle WHERE name=?");
            preparedStatement.setString(1, name);
            System.out.println("searching to delete!... wait for result!");
            System.out.println("Name = " + name);
            result = preparedStatement.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            if (Objects.nonNull(connect)) {
                try {
                    connect.close();
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
            }
        }
        return result;
    }

    public  void showDetails()
    {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

        Connection connect = null;
        try
        {
            connect = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/Kingfisher_db", "root", "root");
            PreparedStatement preparedStatement = connect.prepareStatement("SELECT * FROM water_bottle");
            //preparedStatement.setString(1, waterBottleDetailsDto.getName());
            System.out.println("collecting details!... wait for result!");
            //System.out.println("Name = " + waterBottleDetailsDto.getName());
            set = preparedStatement.executeQuery();

            while (set.next()) {
                System.out.println("...");
                System.out.println(set.getString("name"));
                System.out.println(set.getFloat("size"));
                System.out.println(set.getDouble("cost"));
                System.out.println(set.getString("validity"));
                System.out.println(set.getBoolean("is_certified"));
                System.out.println("-----------------------------------");
            }
        }
       catch(SQLException e)
       {
           throw new RuntimeException(e);
       }
        finally
        {
            if (Objects.nonNull(connect))
            {
                try
                {
                    connect.close();
                }
                catch (SQLException e)
                {
                    throw new RuntimeException(e);
                }
            }
        }
        if (Objects.nonNull(set))
        {
            try {
                set.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
    }
}