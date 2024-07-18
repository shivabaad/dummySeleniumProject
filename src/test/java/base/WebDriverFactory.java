package base;

import java.io.File;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import pages.SearchItems;

public class WebDriverFactory {
	
	protected static final Logger logger = LogManager.getLogger(WebDriverFactory.class);
	
	private WebDriverFactory() {};
	
	private static final WebDriverFactory instance = new WebDriverFactory();
	
	private static ThreadLocal<WebDriver> t = new ThreadLocal<WebDriver>();
	
	public static final WebDriverFactory getInstance() {
		return instance;
	}
	
	public WebDriver getDriver(String browser) {
		 WebDriver driver = null;
		 
		 try {
			 if (driver == null) {
				 if ("chrome".equalsIgnoreCase(browser)) {
					 setDriverPath(browser);
					 driver = new ChromeDriver();
					 t.set(driver);
					 logger.info("Browser used: " + browser);
				 } else if ("firefox".equalsIgnoreCase(browser)) {
					 setDriverPath(browser);
					 driver = new FirefoxDriver();
					 t.set(driver);
					 logger.info("Browser used: " + browser);
				 } else if ("edge".equalsIgnoreCase(browser)) {
					 setDriverPath(browser);
					 driver = new EdgeDriver();
					 t.set(driver);
					 logger.info("Browser used: " + browser);
				 }				 
			 }
		} catch (Exception e) {
			logger.error("The specified %s browser does not exist. The supported browsers are : chrome, firefox, edge");
			e.printStackTrace();
		}
		 
		 return t.get();
	}
	
	public void quitDriver() {
		if (t.get() != null) {
			t.get().quit();
			t.set(null);
		}
	}
	
	public void setDriverPath(String browser) {
		String os = System.getProperty("os.name").substring(0,3);
		logger.info("Operating system: " + os);
		String fileExtension = os.equalsIgnoreCase("win")? ".exe" : "";
		String key = null;
		String value = null;
		String homeDir = System.getProperty("user.dir");
		if ("chrome".equalsIgnoreCase(browser)) {
			key = "webdriver." + browser + ".driver";
			value = homeDir + File.separator + "drivers" + File.separator + "chromedriver" + fileExtension;
		} else if ("firefox".equalsIgnoreCase(browser)) {
			key = "webdriver." + browser + ".driver";
			value = homeDir + File.separator + "drivers" + File.separator + "geckodriver" + fileExtension;
		} else if ("edge".equalsIgnoreCase(browser)) {
			key = "webdriver." + browser + ".driver";
			value = homeDir + File.separator + "drivers" + File.separator + "msedgedriver" + fileExtension;
		}
		
		System.setProperty(key, value);
	}
	
}
