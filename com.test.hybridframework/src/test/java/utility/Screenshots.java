package utility;

import java.io.File;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class Screenshots {
	
	public static String captureScreenshots(WebDriver ldriver,String screenshotName)
	{
		
		try {
			
		//TakesScreenshot as pre-defined interface for which we cannot create object
		//create the object of TakeScreenshot interface by typecasting into TakesScreenshot webdriver
			
		TakesScreenshot ts=(TakesScreenshot)ldriver;
		
		//capture the screenshot and store it in source file
		File source=ts.getScreenshotAs(OutputType.FILE);
		
		//creating patih for destination folder
		String dest="G:\\SeleniumWorkspace\\com.test.hybridframework\\Screenshots\\"+screenshotName+System.currentTimeMillis()+".png";
		
		//mention the destination path
		File destination=new File(dest);
		
		//using FileUtils copy the file from source to destination
		FileUtils.copyFile(source, destination);
		
		//System.out.println("Screenshot taken.");
		return dest;
		
		} 
		catch (Exception e) 
		{

			System.out.println("Exception while creating screen shots is:" +e.getMessage());
			
			return e.getMessage();
			
		}
		
	}

}
