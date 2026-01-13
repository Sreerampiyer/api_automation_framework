package aut.util;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.util.*;

public final class ExcelReader {

    private ExcelReader() {}

    public static List<Map<String, String>> getTestData(
            String filePath, String sheetName) {

        List<Map<String, String>> dataList = new ArrayList<>();

        try (FileInputStream fis = new FileInputStream(filePath);
             Workbook workbook = new XSSFWorkbook(fis)) {

            Sheet sheet = workbook.getSheet(sheetName);
            Row headerRow = sheet.getRow(0);

            for (int i = 1; i <= sheet.getLastRowNum(); i++) {

                Row currentRow = sheet.getRow(i);
                if (currentRow == null) continue;

                Map<String, String> dataMap = new HashMap<>();

                for (int j = 0; j < headerRow.getLastCellNum(); j++) {

                    Cell headerCell = headerRow.getCell(j);
                    Cell valueCell = currentRow.getCell(j,
                            Row.MissingCellPolicy.CREATE_NULL_AS_BLANK);

                    dataMap.put(
                            headerCell.getStringCellValue().trim(),
                            valueCell.toString().trim()
                    );
                }

                dataList.add(dataMap);
            }

        } catch (Exception e) {
            throw new RuntimeException("Failed to read Excel data", e);
        }

        return dataList;
    }
}

