package com.Utility;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class Library 
{
	public static WebDriver driver;
	public static Properties objProp;
	
	public static void ReadPropertiesFiles() throws IOException
	{
		try 
		{
			File ObjFile = new File(System.getProperty("user.dir")+"//src//test//resources//Config.Properties");
			FileInputStream ObjFileInput = new FileInputStream(ObjFile);
			objProp = new Properties();
			objProp.load(ObjFileInput);
			System.out.println(objProp.getProperty("browser"));
			//System.out.println(objProp.getProperty("GmoOnlineAppUrl"));
		} catch (FileNotFoundException e) 
		{
			e.printStackTrace();
		}
	}
	
	public static void LaunchBrowser()
	{
		String browserFromPropFile = objProp.getProperty("browser");
		switch (browserFromPropFile.toLowerCase()) 
		{
		case "chrome":
			driver = new ChromeDriver();
			break;
		case "firefox":
			driver = new FirefoxDriver();
			break;
		case "edge":
			driver = new EdgeDriver();
			break;
		case "ie":
			driver = new InternetExplorerDriver();
			break;
		default:
			System.out.println("Please provide browser name");
		}
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(Constants.ImplicitWaitTimeOut));
	}
	
	public void PageLoadTimeOut(int seconds)
	{
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(seconds));
	}
	
}
