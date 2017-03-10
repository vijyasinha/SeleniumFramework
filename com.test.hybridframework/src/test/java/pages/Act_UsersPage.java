package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Act_UsersPage {
	WebDriver driver;
	
	Act_UsersPage(WebDriver driver)
	{
		this.driver=driver;
	}
	@FindBy(xpath="//div[@class='label' and text()='USERS']")WebElement userTab;
	@FindBy(xpath="//*[text()='User List']")WebElement pageHeading;
	@FindBy(xpath="//div[@class='inviteUsersButton beigeButton useNativeActive']")WebElement userButton;
	
	public void userTab()
	{
		userTab.click();
	}
	
	public String getTitle()
	{
		String title = driver.getTitle();
		
		return title;
	}

	public void userButton()
	{
		userButton.click();
	}
}
