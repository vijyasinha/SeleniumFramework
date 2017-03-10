package testCases;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import factory.BrowserFactory;
import factory.DataProviderFactory;
import pages.GInbox_page;
import pages.GLogin_Page;

public class GLogin_001 {
	WebDriver driver;
	
	@DataProvider
	@Test
	public void login() throws InterruptedException
	{
		driver = BrowserFactory.getBrowser("Firefox");
		driver.get(DataProviderFactory.getConfig().getGmailUrl());
		
		GLogin_Page login=PageFactory.initElements(driver, GLogin_Page.class);
		
		
		login.SignIn("vijya157", "Apply@1234");
		Thread.sleep(3000);
		//Assert.assertTrue(login.verifyPageTitle(), "Page title is not displaying properly.");
		//Assert.assertTrue(login.verifyPageText(), "Sign in to continue to Gmail is not displaying in page heading.");
		
		GInbox_page inbox=PageFactory.initElements(driver, GInbox_page.class);
		Assert.assertTrue(inbox.verifyPageTitle(), "User is not in Inbox page");
		System.out.println(inbox.getInboxnPageTitle());
		System.out.println("Login success!!");
		
		BrowserFactory.closeBrowser(driver);
	}

}
