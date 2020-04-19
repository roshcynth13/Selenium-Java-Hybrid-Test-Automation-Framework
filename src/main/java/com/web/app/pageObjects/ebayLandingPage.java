package com.web.app.pageObjects;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ebayLandingPage {
	
	public WebDriver driver;
	
	By searchBoxTextebay = By.xpath("//input[@id='gh-ac']");
	By searchItemButtonebay = By.xpath("//input[@id='gh-btn']");
	
	public ebayLandingPage(WebDriver driver) {
		
		this.driver = driver;
	}

	public WebElement getSearchTextBox() {
		
		return driver.findElement(searchBoxTextebay);
		
	}
	
    public WebElement getSearchItemButton() {
		
		return driver.findElement(searchItemButtonebay);
		
	
	}
    
 
	
	

}
