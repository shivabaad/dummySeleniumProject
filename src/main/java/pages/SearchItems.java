package pages;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.Base;
import base.SortItemsBy;

public class SearchItems extends Base {
	
	@FindBy (xpath = "//div[@class='_75nlfW']//div[@class='KzDlHZ']")
	List<WebElement> itemsSearched;
	
	private WebDriver driver;
	
	protected static final Logger logger = LogManager.getLogger(SearchItems.class);

	public SearchItems(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public boolean isSearchSuccessful() {
		return !itemsSearched.isEmpty();
	}
	
	public void sortItems(SortItemsBy sort) {
		logger.info("Sorting items by: " + sort.toString());
		String sortBy = String.format("//div[@class='sHCOk2']/div[contains(text(),'%s')]", sort.toString()); 
		WebElement sortType = driver.findElement(By.xpath(sortBy));
		sortType.click();		
	}

}
