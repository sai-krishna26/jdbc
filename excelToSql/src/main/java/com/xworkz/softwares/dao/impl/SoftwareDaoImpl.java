package com.xworkz.softwares.dao.impl;

import com.xworkz.softwares.dao.SoftwareDao;
import com.xworkz.softwares.dto.SoftwareDto;

import java.sql.*;
import java.util.Collection;
import java.util.List;

public class SoftwareDaoImpl implements SoftwareDao {

    @Override
    public String batchInsert(List<SoftwareDto> list) {
        Connection connection=null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection=DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/software_db","root","root");
            PreparedStatement preparedStatement=connection.prepareStatement("insert into software_info values(?,?,?,?,?)");

            for(SoftwareDto dto:list)
            {
                preparedStatement.setString(1,dto.getName());
                preparedStatement.setString(2,dto.getCurrentVersion());
                preparedStatement.setInt(3, dto.getDevelopedDate());
                preparedStatement.setString(4,dto.getDevelopedBy());
                preparedStatement.setString(5,dto.getIsOpenSource());

                preparedStatement.addBatch();
            }

            preparedStatement.executeBatch();
            System.out.println("insertion is successful");
        } catch (ClassNotFoundException | SQLException e) {
            throw new RuntimeException(e);
        }

        return "";
    }
}
