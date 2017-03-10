package testCases;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;

public class ActitimeLogin_001 {
	WebDriver driver;
	ActitimeLogin_001(WebDriver driver)
	{
		this.driver=driver;
	}
	
	@BeforeTest
	public void actitimeLogin()
	{
	 driver= factory.BrowserFactory.getBrowser("firefox");
	
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	
	driver.get("https://online.actitime.com/abc7//login.do");
	
	String pageTitle = driver.getTitle();
	
	Assert.assertTrue(pageTitle.contains("actiTIME - Login"));
	
	driver.findElement(By.id("username")).sendKeys("vijya157");
	driver.findElement(By.name("pwd")).sendKeys("godisgreat");
	driver.findElement(By.id("loginButton")).click();

	}
}
