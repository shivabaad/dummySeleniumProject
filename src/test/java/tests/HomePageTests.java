package tests;

import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;

import base.BaseTest;
import base.SortItemsBy;

public class HomePageTests extends BaseTest {
	
	List<String> expectedCategories = new ArrayList<>(List.of("Grocery", "Mobiles", "Fashion", "Electronics", "Home & Furniture", "Appliances", "Travel", "Beauty, Toys & More", "Two Wheelers"));
//	private static final Logger logger = LogManager.getLogger(HomePageTests.class);
	
	@Test
	public void checkURL() {
		Assert.assertEquals(flipkart.getCurrentURL(), "https://www.flipkart.com/");
	}
	
	@Test
	public void checkTitle() {
		Assert.assertEquals(flipkart.getTitle(), "Online Shopping Site for Mobiles, Electronics, Furniture, Grocery, Lifestyle, Books & More. Best Offers!");
	}
	
	@Test
	public void checkForCategories() {
		boolean output = expectedCategories.equals(flipkart.getCategoryNames());
		Assert.assertTrue(output);
	}	

}
