package resources;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;

import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class BaseClass {
	
	public static WebDriver driver;
	public Properties prop;
	
	public WebDriver initializeDriver() throws IOException {
		
	    prop = new Properties();
		FileInputStream fis = new FileInputStream("/Users/roshantocynthia/WebAutomationFW/src/main/java/resources/data.properties");
		prop.load(fis);
		String browserName= prop.getProperty("browser");
		
		/* This code is being developed in Mac Machine. Hence No setProperty() is required as the external drivers are loaded from the directory "/usr/local/bin" */
		
		if (browserName.equals("chrome")) {
				
			driver = new ChromeDriver();
			
		}
		
		else if (browserName.equals("firefox")) {
			
			//System.setProperty("webdriver.gecko.driver", "/Users/roshantocynthia/ExtD/geckodriver.exe");
			driver = new FirefoxDriver();
			
			
		}
		
		else if (browserName.equals("cvv")) {
			
			/* to be added */ 
			
			
		}
		
		/* An implicit wait applied across all Test Cases */
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
	    return driver;
	  
	}

	public void getScreenshot(String result) throws IOException {
		
		File src=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(src, new File("/Users/roshantocynthia/WebAutomationFW/screenshots/"+result+"screenshot.png"));
		
	}

	
	
}
