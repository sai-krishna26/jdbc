package com.xworkz.softwares.runner;

import com.xworkz.softwares.dto.SoftwareDto;
import com.xworkz.softwares.service.SoftwareService;
import com.xworkz.softwares.service.impl.SoftwareServiceImpl;
import com.xworkz.softwares.util.ExcelReaderUtil;

import java.util.List;

public class SoftwareRunner {

    public static void main(String[] args) {
        SoftwareService softwareService=new SoftwareServiceImpl();
        String path="D:/jdbc/excelToSql/src/main/resources/sws_sheet.xlsx";
        List<SoftwareDto> list= ExcelReaderUtil.readExcel(path);
        String result=softwareService.ValidateBatchInsert(list);
        System.out.println("result: "+result);
    }
}
