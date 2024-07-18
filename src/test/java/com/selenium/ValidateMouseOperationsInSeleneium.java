package com.selenium;

import org.testng.annotations.Test;

import com.POM.MouseOperationsPOM;
import com.Utility.Constants;
import com.Utility.Library;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;

import java.io.IOException;

import org.openqa.selenium.Alert;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.AfterSuite;

public class ValidateMouseOperationsInSeleneium extends Library{
  
  @Test(priority=0)
	
  public void ValidateLoadingOfJQueryApp()
  {
	  System.out.println("inside ValidateLoadingOfJQueryApp");
	  driver.get(objProp.getProperty("mouseOpeartionRightClick"));
	  PageLoadTimeOut(Constants.PageLoadTimeOut);
	  String title = driver.getTitle();
	  Assert.assertEquals(title, objProp.getProperty("JQeryTitle"));
  }
 
  @Test(priority=1)
  public void ValidateRightClickOperation() throws Exception
  {
	  System.out.println("inside ValidateRightClickOperation");
	  Actions objAtions = new Actions(driver);
	  MouseOperationsPOM objMouseOperation = new MouseOperationsPOM();
	  objAtions.contextClick(objMouseOperation.rightClickBtn).build().perform();
	  objMouseOperation.copyOption.click();
	  Alert objAlert = driver.switchTo().alert();
	  Thread.sleep(3000);
	  String TextOnAlert = objAlert.getText();
	  Assert.assertEquals(TextOnAlert, objProp.getProperty("CopyOptionAlertText"));
	  objAlert.accept();
  }
  
  @BeforeMethod
  public void beforeMethod() 
  {
  }

  @AfterMethod
  public void afterMethod() 
  {
  }

  @BeforeClass
  public void beforeClass() 
  {
  }

  @AfterClass
  public void afterClass() 
  {
  }

  @BeforeTest
  public void beforeTest() 
  {
	  System.out.println("inside beforeTest");
	  LaunchBrowser();
  }

  @AfterTest
  public void afterTest()
  {
  }

  @BeforeSuite
  public void beforeSuite() 
  {
	  System.out.println("inside beforeSuite");
	  try {
		  ReadPropertiesFiles();
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	  
  }

  @AfterSuite
  public void afterSuite() 
  {
  }

}
