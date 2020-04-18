package com.web.app.pageObjects;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class amazonLandingPage {
	
	public WebDriver driver;
	
	By searchBoxTexAmazon = By.xpath("//input[@id='twotabsearchtextbox']");
	By searchItemButtomAmazon = By.xpath(" //div[@class='nav-search-submit nav-sprite']//input[@class='nav-input']");
	
	public amazonLandingPage(WebDriver driver) {
		
		this.driver = driver;
	}

	public WebElement getSearchTextBox() {
		
		return driver.findElement(searchBoxTexAmazon);
		
	}
	
    public WebElement getSearchItemButton() {
		
		return driver.findElement(searchItemButtomAmazon);
		
		
	}
    
 
	
	

}
