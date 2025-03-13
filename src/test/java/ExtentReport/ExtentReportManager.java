package ExtentReport;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import java.io.File;

public class ExtentReportManager {

    private static String reportDir = System.getProperty("user.dir") + "/Report";

    private static ExtentReports extentReport;
    private static ExtentSparkReporter extentSparkReporter;


    public static ExtentReports extentSetUp(){

        extentReport = new ExtentReports();
        extentSparkReporter = new ExtentSparkReporter(new File(reportDir));

        extentSparkReporter.config().setDocumentTitle("Betway");
        extentSparkReporter.config().setTheme(Theme.DARK);
        extentSparkReporter.config().setReportName("Betway Test Report");

        extentReport.setSystemInfo("OS", System.getProperty("os.name"));
        extentReport.setSystemInfo("Execution Machine", System.getProperty("user.name"));

        return extentReport;

    }



}
