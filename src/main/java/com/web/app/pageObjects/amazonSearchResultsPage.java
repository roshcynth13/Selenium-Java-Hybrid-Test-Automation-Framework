package com.web.app.pageObjects;

import java.util.List;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;



public class amazonSearchResultsPage {
	
	public WebDriver driver;
	
	By searchResultsbyName = By.xpath("//span[contains(text(),'Sony')]");

	public amazonSearchResultsPage(WebDriver driver) {
		
		this.driver = driver;
		
	}
	
	
	public WebElement getSearchResultsbyName() {
		
		return driver.findElement(searchResultsbyName);
		
	}
	
	public void clickRandomItem() {
		
		List <WebElement> listings = driver.findElements(searchResultsbyName);
		System.out.println("Number of items loaded by searchkeyword Sony is "+" "+listings.size());
	    Random r = new Random();
	    /* Clicking a random results */
	    int randomValue = r.nextInt(listings.size());
	    listings.get(randomValue).click();	
	    
	}
	
	
	
	
    		
	
	
   

}
