package base;

import java.io.File;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentManager {
	private static ExtentHtmlReporter htmlReporter;
	private static ExtentReports extent;
	
//    private static ThreadLocal<ExtentTest> test = new ThreadLocal<>();

    public static ExtentReports getExtentReports() {
    	htmlReporter = new ExtentHtmlReporter(System.getProperty("user.dir") + File.separator + "test-output" + File.separator + "report.html");

		htmlReporter.config().setDocumentTitle("Automation report");
		htmlReporter.config().setReportName("Functional report");
		htmlReporter.config().setTheme(Theme.DARK);

		extent = new ExtentReports();
		extent.attachReporter(htmlReporter);

		extent.setSystemInfo("OS", System.getProperty("os.name"));
		extent.setSystemInfo("Tester name", "Shiva");
//		extent.setSystemInfo("Browser", "Chrome");
		
		return extent;
    }
}



