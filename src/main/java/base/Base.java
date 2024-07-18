package base;

import java.time.Duration;
import java.util.NoSuchElementException;
import java.util.ResourceBundle;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Base {
	
	protected static final Logger logger = LogManager.getLogger(Base.class);

	private WebDriver driver;
	private WebDriverWait wait;

	private Long waitDuration = Long.parseLong(ResourceBundle.getBundle("conf").getString("explicitWaitDuration"));
	private Long implictWaitDuration = Long
			.parseLong(ResourceBundle.getBundle("conf").getString("implicitWaitDuration"));

	public Base(WebDriver driver) {
		this.driver = driver;
		wait = new WebDriverWait(driver, Duration.ofSeconds(waitDuration));
	}

	public void sendText(WebElement element, String text) {
		element.clear();
		logger.info("Text cleared");
		element.sendKeys(text);
		logger.info("Entered text: " + text);
	}

	public void refresh() {
		driver.navigate().refresh();
		logger.info("Current browser location was refreshed");
	}

	public String getTitle() {
		String title = driver.getTitle();
		logger.info("The title of current page is: " + title);
		return title;
	}

	public String getCurrentURL() {
		String url = driver.getCurrentUrl();
		logger.info("The URL of current page is: " + url);
		return url;
	}

	public WebElement waitForElement(WebElement element) {

		try {
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(0));
			return wait.until(ExpectedConditions.visibilityOf(element));
		} catch (NoSuchElementException e) {
			e.printStackTrace();
		} finally {
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(implictWaitDuration));
		}
		return null;

	}

}
