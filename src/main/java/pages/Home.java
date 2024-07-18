package pages;

import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.Base;

public class Home extends Base {
	
	@FindBy (xpath = "//div[@class='_3sdu8W emupdz']/*[@class='_1ch8e_']")
	List<WebElement> CATEGORIES;
	
	private WebDriver driver;
	
	protected static final Logger logger = LogManager.getLogger(Home.class);
	
	public Home(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}
	
	public String getTitle() {
		return super.getTitle();
	}
	
	public String getCurrentURL() {
		return super.getCurrentURL();
	}
	
	public List<String> getCategoryNames(){
		List<String> categories = new ArrayList<>();
		CATEGORIES.forEach(t -> categories.add(t.getAttribute("aria-label")));
		logger.info("Categories found: " + categories);
		return categories;
	}
	
	

}
