package com.web.app;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.AssertJUnit;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import resources.BaseClass;

public class TC_002X_Item_Purchase_Ebay extends BaseClass {
	
	public static Logger log = LogManager.getLogger(BaseClass.class.getName());
	
	@BeforeTest
	public void setUp() throws IOException {
		
		driver = initializeDriver();
		log.info("driver is initialized");
	    driver.get(prop.getProperty("ebayURL"));
		log.info("Navigated to ebay ");
	   
		
	}
	
	
	@Test
	public void purchaseanItemEbay() throws IOException {
		
		log.info("Asserting the page title");
	    AssertJUnit.assertEquals(driver.getTitle(), "Electronics, Cars, Fashion, Collectibles & More | eBay");
	    
		
	}
	
	@AfterTest
	public void tearDown() {
		
		driver.close();
		driver = null;
	}


}
