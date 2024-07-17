package com.selenium;

import org.testng.annotations.Test;

import com.POM.AlertsPOM;
import com.Utility.Constants;
import com.Utility.Library;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.AfterSuite;

public class ValidateAlertsInSelenium extends Library
{
  @Test(priority=0)
  public void ValidateLaunchAlertsOnDemoQA() 
  {
	  driver.get(objProp.getProperty("AlertsURL"));
	  PageLoadTimeOut(Constants.PageLoadTimeOut);
	  String title=driver.getTitle();
	  Assert.assertEquals(title, objProp.getProperty("TitleOfDemoQA"));
  }
  
  @Test(priority=1)
  public void ValidateNormalAlertOnDemoQA() throws InterruptedException
  {
	  System.out.println("inside ValidateNoramlAlertOnDemoQA");
	  AlertsPOM objPOM = new AlertsPOM(driver);
	  
	  JavascriptExecutor js = (JavascriptExecutor) driver;
	  js.executeScript("arguments[0].scrollIntoView();", objPOM.NormalAlertButton);
	  
	  
	  objPOM.NormalAlertButton.click();
	  Alert objAlert= driver.switchTo().alert();
	  Thread.sleep(3000);
	  String textOfNormalAlert= objAlert.getText();
	  Assert.assertEquals(textOfNormalAlert, objProp.getProperty("TextMessageOfNormalAlert"));
	  objAlert.accept();
  }
  
  @Test(priority=2, enabled = false)
  public void ValidateTimerAlertOnDemoQA() throws InterruptedException
  {
	  System.out.println("inside ValidateTimerAlertOnDemoQA");  
	  AlertsPOM objPOM = new AlertsPOM(driver);
	  objPOM.TimerAlertButton.click();
	  WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(30));
	  wait.until(ExpectedConditions.alertIsPresent());
	  Alert objAlert = driver.switchTo().alert();
	  Thread.sleep(3000);
	  String textOfTimerAlert = objAlert.getText();
	  Assert.assertEquals(textOfTimerAlert, objProp.getProperty("TextOfTimerAlert"));
	  objAlert.accept();
  }
  
  @Test(priority=3, enabled = false)
  public void ValidateConfirmBoxAlertOnDemoQA()
  {
	  System.out.println("inside ValidateConfirmBoxAlertOnDemoQA");  
	  AlertsPOM objPOM = new AlertsPOM(driver);
	  objPOM.confirmButton.click();
	  Alert objAlerts = driver.switchTo().alert();
	  String textOfConfirmBoxAlert = objAlerts.getText();
	  Assert.assertEquals(textOfConfirmBoxAlert, objProp.getProperty("TextOfConfirmBoxAlert"));
	  objAlerts.dismiss();
	  boolean ConfirmAlertResult = objPOM.confirmResult.isDisplayed();
	  Assert.assertEquals(ConfirmAlertResult, true);
  }
  
  @Test(priority=4, enabled = false)
  public void ValidatePromptBoxAlertOnDemoQA()
  {
	  System.out.println("inside ValidatePromptBoxAlertOnDemoQA"); 
	  AlertsPOM objAlertsPOM = new AlertsPOM(driver);
	  objAlertsPOM.promptButton.click();
	  Alert objAlert = driver.switchTo().alert();
	  String textDisplayed = objAlert.getText();
	  Assert.assertEquals(textDisplayed, objProp.getProperty("TextMessageOfPromptBoxAlert"));
	  objAlert.sendKeys("PromptBoxMessageEntered");
	  objAlert.accept();
	  String PromptBoxResultMessageDisplayed = objAlertsPOM.promptResult.getText();
	  Assert.assertEquals(PromptBoxResultMessageDisplayed, objProp.getProperty("PromptBoxResult"));
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
	  try 
	  {
		ReadPropertiesFiles();
	  } catch (IOException e) 
	  {
		e.printStackTrace();
	  }
  }

  @AfterSuite
  public void afterSuite() 
  {
	  
  }

}
