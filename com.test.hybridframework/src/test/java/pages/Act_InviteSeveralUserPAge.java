package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Act_InviteSeveralUserPAge {
	
	WebDriver driver;
	Act_InviteSeveralUserPAge(WebDriver driver)
	{
		this.driver=driver;
	}
	
	@FindBy(id="inviteSeveralUsersLightBox_titlePlaceholder")WebElement pageHeading;
	@FindBy(xpath="//div[@class='tableLabel']")WebElement pageTitle;

}
