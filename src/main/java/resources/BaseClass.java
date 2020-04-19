package resources;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.openqa.selenium.OutputType;

import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class BaseClass {
	
	/* Base Class provides the requires set ups and sourcing features */
	
	public static WebDriver driver;
	public Properties prop;
	
	public WebDriver initializeDriver() throws IOException {
		
	    prop = new Properties();
		FileInputStream fis = new FileInputStream("data.properties");
		prop.load(fis);
		String browserName= prop.getProperty("browser");
		
		/* No setProperty() is required in MAC Machine as the external drivers are loaded from the directory "/usr/local/bin" */
	
		/**
		 * For Windows OS - Use 	System.setProperty("webdriver.chrome.driver", "path of the driver")
		 * 
		 */
		
		if (browserName.equals("chrome")) {
				
			driver = new ChromeDriver();
			
		}
		
		else if (browserName.equals("firefox")) {	
			
			driver = new FirefoxDriver();	
			
		}

		
		/* An implicit wait applied across all Test Cases */
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
	    return driver;
	  
	}

	public void getScreenshot(String result) throws IOException {
		
		/* The TestNG Listener manages the ability to take screenshots which can be configured in listener.java class */
		
		File src=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(src, new File("screenshots/"+result+"screenshot.png"));
		
	}

	
}
