package testCases;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

import pages.Act_UsersPage;

public class Actitme_InviteSeveralUser {
	WebDriver driver;
	
	@Test
	public void InviteSeveralUser() throws InterruptedException
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
		
		Thread.sleep(4000);
		//Instantiate the instance of user page by using pagefactory class and initElements method
		Act_UsersPage user=PageFactory.initElements(driver, Act_UsersPage.class);
		
		//enter on user tab and verify the title of the page.
		user.userTab();
		//driver.findElement(By.xpath("//a[@class='content users']/div[@class='label']")).click();
		String titlepage = user.getTitle();
		Assert.assertTrue(titlepage.contains("User List"));
		System.out.println("page title is verified successfully");
		
		//enter on the user button and select for invite several user option
		user.userButton();
		
		List<WebElement> dd_list = driver.findElements(By.xpath("//div[@class='content ui-dialog-content ui-widget-content']/div/div"));
		
		for(WebElement list:dd_list)
		{
			String text = list.getText();
			if(text.equalsIgnoreCase("Invite several user at once"))
			{
				list.click();
				break;
			}
		}
		
		
	}

}
