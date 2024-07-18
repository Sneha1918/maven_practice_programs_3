package com.POM;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.Utility.Library;

public class MouseOperationsPOM extends Library
{
	public MouseOperationsPOM()
	{
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//span[@class='context-menu-one btn btn-neutral']")
	public WebElement rightClickBtn;
	
	@FindBy(xpath = "//span[text()='Copy']")
	public WebElement copyOption;
	
	
	
	
	
}
