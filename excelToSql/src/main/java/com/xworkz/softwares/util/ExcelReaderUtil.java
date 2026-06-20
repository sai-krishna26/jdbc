package com.xworkz.softwares.util;

import com.xworkz.softwares.dto.SoftwareDto;
import org.apache.poi.ss.usermodel.*;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class ExcelReaderUtil {
public static List<SoftwareDto> readExcel(String path)
{
    List<SoftwareDto> list=new ArrayList<>();

    try {
        FileInputStream fileInputStream=new FileInputStream(path);
        Workbook workbook= WorkbookFactory.create(fileInputStream);
        Sheet sheet=workbook.getSheetAt(0);
        boolean firstRow=true;

        for(Row row:sheet)
        {
            if(firstRow)
            {
                firstRow=false;
                continue;
            }
            DataFormatter formatter = new DataFormatter();

            SoftwareDto softwareDto = new SoftwareDto();

            softwareDto.setName(formatter.formatCellValue(row.getCell(0)));

            softwareDto.setCurrentVersion(formatter.formatCellValue(row.getCell(1)));

            softwareDto.setDevelopedDate(Integer.parseInt(formatter.formatCellValue(row.getCell(2))));

            softwareDto.setDevelopedBy(formatter.formatCellValue(row.getCell(3)));

            softwareDto.setIsOpenSource(formatter.formatCellValue(row.getCell(4)));

            list.add(softwareDto);
        }
        workbook.close();

    } catch (IOException e) {
        throw new RuntimeException(e);
    }
    return list;
}
}
