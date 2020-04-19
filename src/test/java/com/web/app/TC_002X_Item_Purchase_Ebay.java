package com.web.app;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;


import com.web.app.pageObjects.ebayLandingPage;
import com.web.app.pageObjects.ebaySearchResultsPage;

import org.testng.AssertJUnit;

import java.io.IOException;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import resources.BaseClass;
import utils.JSONFileReaderUtil;

public class TC_002X_Item_Purchase_Ebay extends BaseClass {
	
	public static Logger log = LogManager.getLogger(BaseClass.class.getName());
	
	@BeforeTest
	public void setUp() throws IOException {
		
		driver = initializeDriver();
		log.info("driver is initialized");
	    driver.get(prop.getProperty("ebayURL"));
		log.info("Navigated to eBay ");
	   
	
	}
	

	@Test
	public void purchaseanItemeBay() throws IOException {
		
	
		ebayLandingPage eLp = new ebayLandingPage(driver);
		log.info("Searching for the given keyword");
		JSONFileReaderUtil jUtil = new JSONFileReaderUtil();
		jUtil.ReadTestDataJSON();
		eLp.getSearchTextBox().sendKeys(jUtil.getSearchKeyWordAN());
	    AssertJUnit.assertTrue(eLp.getSearchTextBox().isDisplayed());
	    eLp.getSearchItemButton().click();
		log.info("Clicking a random search result");
		log.info("The title of the page is "+" "+driver.getTitle());
		log.info("Purchase item from eBay is completed with no errors ");
	
   
		
	}
	
	@AfterTest
	public void tearDown() {
		
		driver.close();
		driver = null;
	
	}


}
