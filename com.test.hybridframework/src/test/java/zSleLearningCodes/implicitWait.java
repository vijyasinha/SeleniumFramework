package zSleLearningCodes;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

public class implicitWait {

	
	//implicit wait will wait for the webelement for specified period of time throughout the entire script.
	@Test
	public void verifySeleniumtitle()
	{
		WebDriver driver=factory.BrowserFactory.getBrowser("firefox");
		driver.manage().window().maximize();
		driver.get("https://www.facebook.com/login/");
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.findElement(By.id("emaiil")).sendKeys("vijya");
	}
}
