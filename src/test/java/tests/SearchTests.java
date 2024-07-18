package tests;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import base.BaseTest;
import base.SortItemsBy;



public class SearchTests extends BaseTest {
	
	@Test
	public void searchItemFromHomepage() {
		boolean output = searchBar.searchItem("mobile").isSearchSuccessful();
		Assert.assertTrue(output);
	}
	
	@Test
	public void sortItems() {
		searchBar.searchItem("mobile").sortItems(SortItemsBy.LOW_TO_HIGH);
		
	}
	
}
