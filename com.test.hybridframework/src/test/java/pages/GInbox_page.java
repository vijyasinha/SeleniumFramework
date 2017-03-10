package pages;

import org.openqa.selenium.WebDriver;

public class GInbox_page {
	
	WebDriver driver;
	
	public GInbox_page(WebDriver driver)
	{
		this.driver=driver;
	}

	public String getInboxnPageTitle()
	{
		String pagetitle = driver.getTitle();
		return pagetitle;
	}
	
	public boolean verifyPageTitle()
	{
		String expectedTitle="Inbox";
		return getInboxnPageTitle().contains(expectedTitle);
		
	}
}
