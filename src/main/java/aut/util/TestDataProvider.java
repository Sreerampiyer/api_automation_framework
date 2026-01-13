package aut.util;

import org.testng.annotations.DataProvider;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class TestDataProvider {

    //@DataProvider(name = "apiTestData")
    public static Object[][] getTestData(String excelPath) {

        //String excelPath = "src/test/resources/testdata/Test_Data.xlsx";

        List<Map<String, String>> allData =
                ExcelReader.getTestData(excelPath, "Sheet1");

        List<Map<String, String>> runnableData =
                allData.stream()
                        .filter(data -> data.get("Run").equalsIgnoreCase("Y"))
                        .collect(Collectors.toList());

        Object[][] dataArray = new Object[runnableData.size()][1];

        for (int i = 0; i < runnableData.size(); i++) {
            dataArray[i][0] = runnableData.get(i);
        }

        return dataArray;
    }
}
