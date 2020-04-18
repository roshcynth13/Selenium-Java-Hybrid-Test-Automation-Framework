package com.web.app;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import java.io.IOException;
import com.web.app.pageObjects.amazonLandingPage;
import com.web.app.pageObjects.amazonSearchResultsPage;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import resources.BaseClass;
import utils.JSONFileReaderUtil;

public class TC_001X_Item_Purchase_Amazon extends BaseClass {
	
	public static Logger log = LogManager.getLogger(BaseClass.class.getName());
	
	
	@BeforeTest
	public void setUp() throws IOException {
		
		driver = initializeDriver();
		log.info("driver is initialized");
	    driver.get(prop.getProperty("amazonURL"));
		log.info("Navigated to Amazon ");
	   
		
	}
	

	@Test
	public void purchaseanItemAmazon() throws IOException {
		
		
	    amazonLandingPage aLp = new amazonLandingPage(driver);
		log.info("Searching for the given keyword");
		JSONFileReaderUtil jUtil = new JSONFileReaderUtil();
		jUtil.ReadTestDataJSON();
	    aLp.getSearchTextBox().sendKeys(jUtil.getSearchKeyWordAN());
	    AssertJUnit.assertTrue(aLp.getSearchTextBox().isDisplayed());
	    aLp.getSearchItemButton().click();
	    amazonSearchResultsPage aSp = new amazonSearchResultsPage(driver);
		log.info("Clicking a random search result");
	    aSp.clickRandomItem();
		log.info("The title of the page is "+" "+driver.getTitle());
		log.info("Purchase item from amazon is completed with no errors ");
	
   
		
	}
	
	@AfterTest
	public void tearDown() {
		
		driver.close();
		driver = null;
	
	}

}
