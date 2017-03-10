package testCases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import dataProviders.ExcelDataProvider;
import factory.BrowserFactory;

public class LI_TC01 {
	
	WebDriver driver;
	
	@Test(dataProvider="loginData")
	public void login(String username,String password) throws InterruptedException
	{
		driver=BrowserFactory.getBrowser("firefox");
		driver.get("https://accounts.google.com/ServiceLogin?service=mail&passive=true&rm=false&continue=https://mail.google.com/mail/&ss=1&scc=1&ltmpl=default&ltmplcache=2&emr=1&osid=1#identifier");
		driver.findElement(By.id("Email")).sendKeys(username);
		driver.findElement(By.id("next")).click();
		
		driver.findElement(By.id("Passwd")).sendKeys(password);
		driver.findElement(By.id("signIn")).click();
		Thread.sleep(4000);
		//System.out.println(driver.getTitle());
		Assert.assertTrue(driver.getTitle().contains("Inbox"),"Not able to login because of not valid credential.");
		
		System.out.println("Login succesfully!");
		
		driver.findElement(By.xpath("//a/span[@class='gb_9a gbii']")).click();
		
		driver.findElement(By.linkText("Sign out")).click();
		
		System.out.println(driver.getTitle());
		
		
	}
	
	@AfterMethod
	public void teardown()
	{
		driver.quit();
	}
	
	@DataProvider(name="loginData")
	public Object[][] loginCredential()
	{
		ExcelDataProvider ex=new ExcelDataProvider();
		int rowcount = ex.getRowCount(0);
		Object[][] data=new Object[rowcount][2];
		
		for(int i=0;i<rowcount;i++)
		{
			data[i][0]=ex.getData(0, i, 0);
			data[i][1]=ex.getData(0, i, 1);
		}
		
		
		return data;
	}
	
	

}
