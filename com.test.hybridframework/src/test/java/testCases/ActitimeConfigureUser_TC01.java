package testCases;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pages.Act_UsersPage;

public class ActitimeConfigureUser_TC01 {
	
	WebDriver driver;
	
	@Test
	public void ConfigureNewUser() throws InterruptedException
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
		
		//Instantiate the instance of user page by using pagefactory class and initElements method
		Act_UsersPage user=PageFactory.initElements(driver, Act_UsersPage.class);
		
		//enetr on usertab and verify the title of the page.
		user.userTab();
		//driver.findElement(By.xpath("//a[@class='content users']/div[@class='label']")).click();
		String titlepage = user.getTitle();
		Assert.assertTrue(titlepage.contains("User List"));
		
		
		driver.findElement(By.xpath("//div[@class='inviteUsersButton beigeButton useNativeActive']/div[@class='buttonText']")).click();
		
		List<WebElement> elements = driver.findElements(By.xpath("//div[@class='content ui-dialog-content ui-widget-content']/div/div"));
		
		for(WebElement ele:elements)
		{
			System.out.println(ele.getSize());
			String attribute = ele.getAttribute("innerHTML");
			//System.out.println(attribute);
			if(ele.getAttribute("innerHTML").contains("Configure new user profile"))
			{
				ele.click();
				break;
			}
			
		}
		
		 String text = driver.findElement(By.id("userDataLightBox_titlePlaceholder")).getText();
		 
		 System.out.println(text);
		 Assert.assertTrue(text.equals("Add User"), "Not displaying Add User window.");
		
		 driver.findElement(By.name("firstName")).sendKeys("Rahul");
		 
		 driver.findElement(By.name("lastName")).sendKeys("Shinha");
		 
		 driver.findElement(By.name("email")).sendKeys("rs@gmail.com");
		 
		 JavascriptExecutor je=(JavascriptExecutor)driver;
		 
		 WebElement ele1 = driver.findElement(By.xpath("//div[@id='userDataLightBox_commitBtn']"));
		 
		// je.executeAsyncScript("arguments[0].scrollIntoView(true);", ele1);
		 
		 ele1.click();
		 
		 List<WebElement> ele2 = driver.findElements(By.xpath("//div[@class='accountCreatedContainer']/div"));
		 
		 for(WebElement ele:ele2)
		 {
			 String attribute = ele.getAttribute("innerHTML");
				//System.out.println(attribute);
				if(ele.getAttribute("innerHTML").contains("Close"))
				{
					ele.click();
					break;
				}
			 
		 }
		 
		 //search for the created user and verify 
		 driver.findElement(By.xpath("//td/input[@class='filterFieldInput inputFieldWithPlaceholder']")).sendKeys("Rinku");
		 
		 String text2 = driver.findElement(By.xpath("//span[@class='userNameSpan']/span")).getText();
		 System.out.println(text2);
		 Assert.assertTrue(text2.contains("Rinku"),"Created user is not saved in the User List.");
		 
		Thread.sleep(3000);
		
		driver.quit();
	
		
		
	}

}
