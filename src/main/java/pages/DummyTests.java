package pages;

import base.SortItemsBy;

public class DummyTests {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		sortItems(SortItemsBy.HIGH_TO_LOW);
		

	}
	
	public static void sortItems(SortItemsBy sort) {
		String sortBy = String.format("//div[@class='sHCOk2']/div[contains(text(),'%s')]", sort.toString()); 
		System.out.println(sortBy);  
	}

}
