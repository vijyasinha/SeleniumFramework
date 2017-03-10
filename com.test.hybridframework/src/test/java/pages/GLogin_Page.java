package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

public class GLogin_Page {
	
	WebDriver driver;
	
	public GLogin_Page(WebDriver driver)
	{
		this.driver=driver;
	}
	
	@FindBy(xpath="//h2[@class='hidden-small']") WebElement pageHeader;
	@FindBy(id="Email") WebElement emailIdTxtField;
	@FindBy(id="Passwd") WebElement paswdIdTxtField;
	@FindBy(id="next") WebElement nextButton;
	@FindBy(id="signIn") WebElement signInButton;
	@FindBy(id="errormsg_0_Email") WebElement emailErrrMsg;
	@FindBy(id="errormsg_0_Passwd") WebElement pwdErrrMsg;
	
	
	public void enterUserName(String uname)
	{
		if(emailIdTxtField.isDisplayed())
		{
			emailIdTxtField.sendKeys(uname);
			nextButton.click();
			
		}
		
	}
	public void enterPasword(String password)
	{
		if(paswdIdTxtField.isDisplayed())
		{
			paswdIdTxtField.sendKeys(password);
		}
	}
	
	public void nextButton()
	{
		if(nextButton.isDisplayed())
		{
			nextButton.click();
		}
		
	}
	public void SignInButton()
	{
		if(signInButton.isDisplayed())
		{
			signInButton.click();
		}
		
	}
	
	public void SignIn(String username,String pswd)
	{
		String mailIderror = emailErrrMsg.getText();
		String pwdfieldError=pwdErrrMsg.getText();
		enterUserName(username);
		nextButton();
		Assert.assertEquals(mailIderror, "Sorry, Google doesn't recognize that email. ","Msg is not matching as expected.");
		Assert.assertEquals(mailIderror, "Please enter your email. ","Msg is not matching as expected.");
		
		enterPasword(pswd);
		SignInButton();
		
	}
	
	public String getSignInPageTitle()
	{
		String pagetitle = driver.getTitle();
		return pagetitle;
	}
	
	public boolean verifyPageTitle()
	{
		String expectedTitle="Gmail";
		return getSignInPageTitle().contains(expectedTitle);
		
	}
	
	public boolean verifyPageText()
	{
		String pageText = pageHeader.getText();
		String expectedText="Sign in to continue to Gmail";
		boolean b=pageText.contains(expectedText);
		return b;
	}
	
	public String getErrorMessage() {
		String strErrorMsg = null;
		
		if(emailErrrMsg.isDisplayed() && emailErrrMsg.isEnabled())
		{
			strErrorMsg = emailErrrMsg.getText();
		}
		else if(pwdErrrMsg.isDisplayed() && pwdErrrMsg.isEnabled())
		{
			strErrorMsg = pwdErrrMsg.getText();
		}
			
		return strErrorMsg;
	}
}
