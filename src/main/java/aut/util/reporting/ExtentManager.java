package aut.util.reporting;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

public final class ExtentManager {

    private static ExtentReports extent;

    private ExtentManager() {}

    public static synchronized ExtentReports getExtent() {

        if (extent == null) {

            String timeStamp = new SimpleDateFormat("yyyy-MM-dd_HH-mm-ss")
                    .format(new Date());

            String reportPath = "reports/api-automation-report_" +
                    timeStamp + ".html";

            ExtentSparkReporter reporter =
                    new ExtentSparkReporter(new File(reportPath));

            reporter.config().setReportName("API Automation Test Report");
            reporter.config().setDocumentTitle("API Automation Execution");

            extent = new ExtentReports();
            extent.attachReporter(reporter);

            extent.setSystemInfo("Framework", "API Automation");
            extent.setSystemInfo("Language", "Java");
            extent.setSystemInfo("Build Tool", "Gradle");
        }

        return extent;
    }
}
