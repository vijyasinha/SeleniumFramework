package dataProviders;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class ConfigDataProvider 
{
	Properties pro;
	String url;
	
	
	public ConfigDataProvider()
	{
		//create the instance of file and pass the pathname of properties file.
		File src=new File("./Configuration/config.properties");  //if the path agrument is null it throws null pointer exception
		
		try 
		{
			FileInputStream fis=new FileInputStream(src);
			
			 pro=new Properties();
			
			pro.load(fis); //throws IOException and IllegalArgument exception.
			
		} catch (Exception e) 
		{
			System.out.println("Exception is "+e.getMessage());
		}
		
	}
	
	public String getIEPath()
	{
		url=pro.getProperty("IEPath");
		return url;
	}
	
	
	public String getChromePath()
	{
		url=pro.getProperty("chromePath");
		return url;
	}
	
	public String getFirefoxPath()
	{
		url=pro.getProperty("GeckodriverPath");
		return url;
	}
	
	public String getApplicationUrl()
	{
		url=pro.getProperty("appUrl");
		//System.out.println(url);
		return url;
	}
	
	public String getGmailUrl()
	{
		url=pro.getProperty("gmailUrl");
		//System.out.println(url);
		return url;
	}

}
