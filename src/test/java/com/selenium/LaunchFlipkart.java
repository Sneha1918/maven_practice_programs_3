package com.selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class LaunchFlipkart 
{

	static WebDriver driver;
	
	public static void main(String[] args) 
	{
		System.out.println("inside main method");
		System.out.println("inside launch flipkart");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.flipkart.com/");
        driver.findElement(By.name("q")).sendKeys("samsung mobiles");
		driver.findElement(By.xpath("//button[@title='Search for Products, Brands and More']")).click();
		
		//driver.close();
	}

}
