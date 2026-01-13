package aut;

import aut.util.base.BaseTest;
import aut.util.logging.LoggerManager;


import org.apache.logging.log4j.Logger;
import org.testng.annotations.Test;

public class ApiTestRunner extends BaseTest{

    private static final Logger logger =
            LoggerManager.getLogger(ApiTestRunner.class);

    @Test (enabled=true)
    public void verifyLoggingSetup() {
    	System.out.println("inside class");
        logger.info("Extent report initialized successfully");
        test.info("This is a sample Extent log entry");
    }
}
