package zSleLearningCodes;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

public class ScrollTestCase {
	
	@Test
	public void scrollTest() throws InterruptedException
	{
	WebDriver driver=factory.BrowserFactory.getBrowser("Firefox");
	driver.navigate().to("http://learn-automation.com/how-to-scroll-a-page-in-selenium-webdriver/");
	driver.manage().window().maximize();
	
	Thread.sleep(3000);
	JavascriptExecutor je=(JavascriptExecutor)driver;
	je.executeScript("scroll(0,400)");
	
	Thread.sleep(5000);
	
	driver.close();
	}

}
