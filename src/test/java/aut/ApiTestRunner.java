package aut;

import aut.util.LoggerManager;
import aut.util.base.BaseTest;

import org.apache.logging.log4j.Logger;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.annotations.Test;
import aut.util.TestDataProvider;

import java.util.Map;

public class ApiTestRunner extends BaseTest {

	@Test(dataProvider = "sampleapi")
	public void executeApiTest(Map<String, String> testData) {

		String tcId = testData.get("TC_ID");
		String method = testData.get("Method");
		String endpoint = testData.get("Endpoint");

		// Rename Extent test dynamically
		test.getModel().setName(tcId);

		logger.info("Executing Test Case : {}", tcId);
		logger.info("HTTP Method         : {}", method);
		logger.info("Endpoint            : {}", endpoint);

		test.info("Executing Test Case : " + tcId);
		test.info("Method              : " + method);
		test.info("Endpoint            : " + endpoint);
	}

	@DataProvider(name = "sampleapi")
    public static Object[][] getData() {
	
		return TestDataProvider.getTestData("src/test/resources/testdata/Test_Data.xlsx");
	}
}
