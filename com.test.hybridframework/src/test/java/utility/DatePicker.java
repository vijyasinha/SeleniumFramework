package utility;

import java.util.List;

import org.apache.commons.collections4.Get;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class DatePicker {
	
	
	public static void datePicker(WebDriver ldriver,String month,String year,String date)
	{
		WebElement yearEle = ldriver.findElement(By.xpath("//select[@class='ui-datepicker-year']"));
		Select yearSelect=new Select(yearEle);
		yearSelect.selectByVisibleText(year);
		
		WebElement monthEle = ldriver.findElement(By.xpath("//select[@class='ui-datepicker-month']"));
		Select monthSelect=new Select(monthEle);
		monthSelect.selectByVisibleText(month);
		
		List<WebElement> elements = ldriver.findElements(By.xpath("//div[@id='ui-datepicker-div']/table/tbody/tr/td"));
		
		int size = elements.size();
		
		for(int i=1;i<size;i++)
		{
			String dates = elements.get(i).getText();
			
			if(dates.equalsIgnoreCase(date))
			{
				elements.get(i).click();
				break;
			}
			
		}
		
	}
	

}
