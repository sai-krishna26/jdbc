package com.xworkz.softwares.dao;

import com.xworkz.softwares.dto.SoftwareDto;

import java.util.List;

public interface SoftwareDao {
    public String batchInsert(List<SoftwareDto> list);
}
