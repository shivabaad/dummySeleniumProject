package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import base.Base;

public class SearchBar extends Base {
	
	@FindBy (xpath = "//input[contains(@title, 'Search for products, brands and more') or contains(@title, 'Search for Products, Brands and More')]")
	WebElement SEARCH_BAR;
	
	@FindBy (xpath = "//span[@class='BUOuZu']")
	WebElement RESULTS_AFTER_SEARCH;
	
	protected static final Logger logger = LogManager.getLogger(SearchBar.class);
	
	private WebDriver driver;
	
	public SearchBar(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public SearchItems searchItem(String item) {
		sendText(SEARCH_BAR, item);
		SEARCH_BAR.sendKeys(Keys.ENTER);
		String op = waitForElement(RESULTS_AFTER_SEARCH).getText();
		logger.info("Items found: " + op);
		return new SearchItems(driver);
	}
	
	

}
