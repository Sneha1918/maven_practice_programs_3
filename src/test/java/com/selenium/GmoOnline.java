package com.selenium;

import java.time.Duration;

import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import com.POM.GmoOnlinePOM;
import com.Utility.Library;

public class GmoOnline extends Library
{

	public static void main(String[] args) 
	{
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://demo.borland.com/gmopost/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		
		GmoOnlinePOM objGmoOnlinePOM = new GmoOnlinePOM(driver);
		objGmoOnlinePOM.EnterGmoOnline.click();
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(60));
		objGmoOnlinePOM.Glacier_Sun_Glasses.clear();
		objGmoOnlinePOM.Glacier_Sun_Glasses.sendKeys("3");
		objGmoOnlinePOM.PlaceAnOrder.click();
		
		String titleOfPlaceOrderPage = driver.getTitle();
		Assert.assertEquals(titleOfPlaceOrderPage, "Place Order");
		
		String unitPriceFromApp = objGmoOnlinePOM.unitPriceFromApp.getText();
		System.out.println("unitPriceFromApp :" +unitPriceFromApp);
		String unitPriceFromAppWithoutDollar = unitPriceFromApp.substring(2);
		System.out.println("unitPriceFromAppWithoutDollar :" +unitPriceFromAppWithoutDollar);
		float floatValueOfUnitPrice = Float.parseFloat(unitPriceFromAppWithoutDollar);
		float calculatedValueOfUnitPrice = floatValueOfUnitPrice*3;
		System.out.println("calculatedValueOfUnitPrice:" +calculatedValueOfUnitPrice);
		
		String totalPriceFromApp = objGmoOnlinePOM.totalPriceFromApp.getText();
		System.out.println("totalPriceFromApp :" +totalPriceFromApp);
		String actualTotalPriceFromAppWithoutDollar = totalPriceFromApp.substring(2);
		System.out.println("actualTotalPriceFromAppWithoutDollar :" +actualTotalPriceFromAppWithoutDollar);
		float calculatedFloatValueOfTotalPriceFromApp = Float.parseFloat(actualTotalPriceFromAppWithoutDollar);
		System.out.println("calculatedFloatValueOfTotalPriceFromApp:" +calculatedFloatValueOfTotalPriceFromApp);
		
		Assert.assertEquals(calculatedValueOfUnitPrice, calculatedFloatValueOfTotalPriceFromApp);
		
		String productTotalFromApp = objGmoOnlinePOM.productTotalFromApp.getText();
		System.out.println("productTotalFromApp :" +productTotalFromApp);
		String productTotalFromAppWithoutDollar = productTotalFromApp.substring(2);
		System.out.println("productTotalFromAppWithoutDollar :" +productTotalFromAppWithoutDollar);
		float floatValueOfProductTotal = Float.parseFloat(productTotalFromAppWithoutDollar);
		System.out.println("floatValueOfProductTotal :" +floatValueOfProductTotal);
		
		String slaesTaxFromApp = objGmoOnlinePOM.slaesTaxFromApp.getText();
		System.out.println("slaesTaxFromApp :" +slaesTaxFromApp);
		String slaesTaxFromAppWithoutDollar = slaesTaxFromApp.substring(2);
		System.out.println("slaesTaxFromAppWithoutDollar :" +slaesTaxFromAppWithoutDollar);
		float floatValueOfSlaesTax = Float.parseFloat(slaesTaxFromAppWithoutDollar);
		System.out.println("floatValueOfSlaesTax :" +floatValueOfSlaesTax);
		
		String shippingAndHandlingFromApp = objGmoOnlinePOM.shippingAndHandlingFromApp.getText();
		System.out.println("shippingAndHandlingFromApp :" +shippingAndHandlingFromApp);
		String shippingAndHandlingFromAppWithoutDollar = shippingAndHandlingFromApp.substring(2);
		System.out.println("shippingAndHandlingFromAppWithoutDollar :" +shippingAndHandlingFromAppWithoutDollar);
		float floatValueOfShippingAndHandling = Float.parseFloat(shippingAndHandlingFromAppWithoutDollar);
		System.out.println("floatValueOfShippingAndHandling :" +floatValueOfShippingAndHandling);

		float calculatedValueOfGrandTotal = floatValueOfProductTotal+floatValueOfSlaesTax+floatValueOfShippingAndHandling;
		System.out.println("calculatedValueOfGrandTotal :" +calculatedValueOfGrandTotal);
		
		String grandTotalFromApp = objGmoOnlinePOM.grandTotalFromApp.getText();
		System.out.println("grandTotalFromApp :" +grandTotalFromApp);
		String grandTotalFromAppWithoutDollar = grandTotalFromApp.substring(2);
		System.out.println("grandTotalFromAppWithoutDollar :" +grandTotalFromAppWithoutDollar);
		float floatValueOfGrandTotalFromApp = Float.parseFloat(grandTotalFromAppWithoutDollar);
		System.out.println("floatValueOfGrandTotal :" +floatValueOfGrandTotalFromApp);
		
		try 
		{
			Assert.assertEquals(floatValueOfGrandTotalFromApp,calculatedValueOfGrandTotal);
			System.out.println("floatValueOfGrandTotal & calculatedValueOfGrandTotal are equal");
		} catch (Exception e) 
		{
			System.out.println("floatValueOfGrandTotal & calculatedValueOfGrandTotal are not equal");
		}
	
		//driver.close();
	}
}
