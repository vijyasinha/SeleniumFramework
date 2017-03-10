package factory;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterMethod;

import dataProviders.ConfigDataProvider;

public class BrowserFactory {
	
	static WebDriver driver;
	
	
	
	public static WebDriver getBrowser(String browserName)
	{
		//ConfigDataProvider config=new ConfigDataProvider();
		if(browserName.equalsIgnoreCase("firefox"))
		{
			
			System.setProperty("webdriver.firefox.marionette", DataProviderFactory.getConfig().getFirefoxPath());
			
			driver=new FirefoxDriver();
			
		}
		else if(browserName.equalsIgnoreCase("chrome"))
		{
			
			System.setProperty("webdriver.chrome.driver", DataProviderFactory.getConfig().getChromePath());
			driver=new ChromeDriver();
		}
		else if(browserName.equalsIgnoreCase("IE"))
		{
			
			System.setProperty("webdriver.ie.driver", DataProviderFactory.getConfig().getIEPath());
			driver=new InternetExplorerDriver();
		}
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(90, TimeUnit.SECONDS);
		return driver;
	}
	
	
	public static void closeBrowser(WebDriver driver)
	{
		driver.quit();
	}

}
