package aut.util.base;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import aut.util.logging.*;
import aut.util.reporting.*;

import java.lang.reflect.Method;

import org.apache.logging.log4j.Logger;
import org.testng.ITestResult;
import org.testng.annotations.*;

public abstract class BaseTest {

    protected static ExtentReports extent;
    protected ExtentTest test;
    protected Logger logger;

    @BeforeSuite(alwaysRun = true)
    public void beforeSuite() {
        extent = ExtentManager.getExtent();
    }

    @BeforeMethod(alwaysRun = true)
    public void beforeMethod(Method method) {
        test = extent.createTest(method.getName());
        logger = LoggerManager.getLogger(this.getClass());
    }

    @AfterMethod(alwaysRun = true)
    public void afterMethod(ITestResult result) {

        if (result.getStatus() == ITestResult.FAILURE) {
            test.fail(result.getThrowable());
            logger.error("Test Failed", result.getThrowable());
        } else if (result.getStatus() == ITestResult.SUCCESS) {
            test.pass("Test Passed");
        } else {
            test.skip("Test Skipped");
        }
    }

    @AfterSuite(alwaysRun = true)
    public void afterSuite() {
        extent.flush();
    }
}
