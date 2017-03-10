package zSleLearningCodes;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.commons.httpclient.methods.ExpectContinueMethod;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class ecplicitWait {
	@Test
	public void explicitwait()
	{
		WebDriver driver=factory.BrowserFactory.getBrowser("firefox");
		driver.manage().window().maximize();
		driver.get("https://www.facebook.com/login/");
		WebDriverWait wait=new WebDriverWait(driver, 25);
		
		//WebElement ele=wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("email")));
		//WebElement ele = wait.until(ExpectedConditions.presenceOfElementLocated(By.id("email")));
		WebElement ele = wait.until(ExpectedConditions.elementToBeClickable(By.id("email")));
		boolean status=ele.isDisplayed();
		if(status)
		{
			System.out.println(status);
			driver.findElement(By.id("email")).sendKeys("vijya");
		}
		else
		{
			System.out.println(status);
		}
		
		driver.quit();
	}

}
