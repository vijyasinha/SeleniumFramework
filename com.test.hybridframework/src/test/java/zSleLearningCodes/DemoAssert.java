package zSleLearningCodes;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class DemoAssert {
	
	@Test
	public static void assertTest() throws InterruptedException
	{
		WebDriver driver=factory.BrowserFactory.getBrowser("firefox");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get("http://www.ksrtc.in/oprs-web/");
		driver.findElement(By.xpath(".//*[@id='searchBtn']")).click();
		Thread.sleep(3000);
		System.out.println(driver.switchTo().alert().getText());
		
		driver.switchTo().alert().accept();
		
		
	}

}
