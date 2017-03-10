package zSleLearningCodes;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import factory.BrowserFactory;

public class ScrollTest2 {

	@Test
	public void scrolTest() throws InterruptedException
	{
		WebDriver driver=factory.BrowserFactory.getBrowser("Firefox");
		driver.manage().window().maximize();
		driver.navigate().to("http://learn-automation.com/how-to-scroll-into-view-in-selenium-webdriver/");
		
		driver.manage().timeouts().implicitlyWait(90, TimeUnit.SECONDS);
		
		JavascriptExecutor je=(JavascriptExecutor)driver;
		
		WebElement ele = driver.findElement(By.xpath(".//*[@id='post-1017']/div[1]/div/div[1]/p[19]"));
		
		je.executeAsyncScript("arguments[0].scrollIntoView(true);", ele);
		
		System.out.println(ele.getText());
		
		Thread.sleep(2000);
		
		driver.close();
		
		
		
		
		
	}
}
