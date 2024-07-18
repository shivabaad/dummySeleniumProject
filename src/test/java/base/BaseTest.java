package base;

import java.time.Duration;
import java.util.ResourceBundle;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Listeners;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

import pages.Home;
import pages.SearchBar;

public class BaseTest {

	private Long implictWaitDuration = Long
			.parseLong(ResourceBundle.getBundle("conf").getString("implicitWaitDuration"));

	public WebDriver driver;
	public String url = ResourceBundle.getBundle("URL").getString("url");
	public Home flipkart;
	public SearchBar searchBar;

	public ExtentReports extent;
	public ExtentTest test;

	private static final Logger logger = LogManager.getLogger(BaseTest.class);

	@Parameters({ "browser" })
	@BeforeClass
	public void setupClass(@Optional("chrome") String browser) {
		driver = WebDriverFactory.getInstance().getDriver(browser);
		flipkart = new Home(driver);
		searchBar = new SearchBar(driver);
		driver.manage().window().maximize();
	}

	@AfterClass
	public void teardownClass() {
		logger.info("Closing browser instance.");
		WebDriverFactory.getInstance().quitDriver();
	}

	@BeforeMethod
	public void setup() {
		driver.get(url);
		logger.info("Opened URL: " + url);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(implictWaitDuration));
	}

	@Parameters({ "browser" })
	@BeforeSuite
	public void setupSuite(@Optional("chrome") String browser) {
		extent = ExtentManager.getExtentReports();
	}

	@AfterSuite
	public void tearDown() {
		extent.flush();
	}

	/*
	 * @AfterMethod public void teardown() {
	 * 
	 * }
	 */
}
