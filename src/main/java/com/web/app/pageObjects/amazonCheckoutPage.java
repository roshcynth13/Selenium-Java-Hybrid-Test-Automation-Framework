package com.web.app.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class amazonCheckoutPage {
	
public WebDriver driver;
	
	By purchaseButton = By.xpath("//span[contains(text(),'Sony')]");

	public amazonCheckoutPage(WebDriver driver) {
		
		this.driver = driver;
		
	}
	
	
	public WebElement getPurchaseButton() {
		
		return driver.findElement(purchaseButton);
		
	}

}
