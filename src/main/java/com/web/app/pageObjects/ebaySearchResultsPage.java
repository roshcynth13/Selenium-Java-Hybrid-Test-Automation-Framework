package com.web.app.pageObjects;

import java.util.List;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;



public class ebaySearchResultsPage {
	
	public WebDriver driver;
	
	By searchResultsbyNameeBay = By.xpath("//a[contains(text(),'Sony')]");

	public ebaySearchResultsPage(WebDriver driver) {
		
		this.driver = driver;
		
	}
	
	
	public void clickeBayRandomItem() {
	
		List <WebElement> listings = driver.findElements(searchResultsbyNameeBay);
		System.out.println("Number of items loaded by searchkeyword Sony in eBay is "+" "+listings.size());
	    Random r = new Random();
	    /* Clicking a random search result  */
	    int randomValue = r.nextInt(listings.size());
	    listings.get(randomValue).click();	
	    
	}
	
	
	
	
    		
	
   

}
