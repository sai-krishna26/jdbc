package com.xworkz.softwares.service;

import com.xworkz.softwares.dto.SoftwareDto;

import java.util.List;

public interface SoftwareService {
    public String ValidateBatchInsert(List<SoftwareDto> list);
}
