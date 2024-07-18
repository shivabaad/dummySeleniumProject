package base;

import java.io.File;
import java.io.IOException;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;

import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.annotations.Parameters;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

public class TestListener extends BaseTest implements ITestListener {

	protected static final Logger logger = LogManager.getLogger(TestListener.class);
	
	private static ExtentTest test;
	
	@Override
	public void onTestStart(ITestResult result) {
//		System.out.println(Arrays.toString(result.getFactoryParameters()));	
		test = ExtentManager.getExtentReports().createTest(result.getName());

	}

	@Override
	public void onTestSuccess(ITestResult result) {
		logger.info("Test successful: " + result.getName());
		test.log(Status.PASS, "Test case passed is " + result.getName());
	}

	@Override
	public void onTestFailure(ITestResult result) {
		/*
		String path = Utils.getScreenshot(result.getName(), driver);			
		try {
			test.addScreenCaptureFromPath(path);
		} catch (IOException e) {
			e.printStackTrace();
		}
		test.log(Status.FAIL, "Test case failed is " + result.getName());
		test.log(Status.FAIL, "Test case failed is " + result.getThrowable());
		*/
//		String screenshotPath = Utils.getScreenshot(result.getName(), driver);
		logger.error("Test failed: " + result.getName());

	}

	@Override
	public void onTestSkipped(ITestResult result) {
		logger.warn("Test skipped: " + result.getName());
		test.log(Status.SKIP, "Test case skipped is " + result.getName());
	}

}
