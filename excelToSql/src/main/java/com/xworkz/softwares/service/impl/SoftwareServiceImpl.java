package com.xworkz.softwares.service.impl;

import com.xworkz.softwares.dao.SoftwareDao;
import com.xworkz.softwares.dao.impl.SoftwareDaoImpl;
import com.xworkz.softwares.dto.SoftwareDto;
import com.xworkz.softwares.service.SoftwareService;

import java.util.List;
import java.util.Objects;

public class SoftwareServiceImpl implements SoftwareService {
    SoftwareDao softwareDao=new SoftwareDaoImpl();
    @Override
    public String validateBatchInsert(List<SoftwareDto> list) {

        if(Objects.isNull(softwareDao))
        {
            System.out.println("DAO is null");
            return "DAO is null";
        }

        if(Objects.isNull(list) || list.isEmpty())
        {
            System.out.println("List should not be empty or null");
            return "found empty or null";
        }

        for(SoftwareDto dto:list)
        {
            if(Objects.isNull(dto))
            {
                System.out.println("dto is null");
                return "dto is null";
            }
            if(dto.getName()==null || dto.getName().trim().isEmpty())
            {
                System.out.println("invalid name");
                return "invalid name";
            }

            if(dto.getCurrentVersion()==null || dto.getCurrentVersion().trim().isEmpty())
            {
                System.out.println("invalid version");
                return "invalid version";
            }

            if(dto.getDevelopedDate()<1940 || dto.getDevelopedDate()>2026)
            {
                System.out.println("invalid date");
                return "invalid developed date";
            }

            if(dto.getDevelopedBy()==null ||dto.getDevelopedBy().trim().isEmpty())
            {
                System.out.println("invalid name");
                return "invalid developer name";
            }

            if(!dto.getIsOpenSource().equalsIgnoreCase("yes") && !dto.getIsOpenSource().equalsIgnoreCase("no"))
            {
                System.out.println("invalid open source");
                return "invalid open source";
            }
        }
        return softwareDao.batchInsert(list);
    }
}
