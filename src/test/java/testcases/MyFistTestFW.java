package testcases;

import org.openqa.selenium.By;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import base.Basetest;
import utilities.ReadXLSdata;

public class MyFistTestFW extends Basetest {
	
	@Test(dataProviderClass = ReadXLSdata.class,dataProvider = "bvtdata")
	public static void  LoginTest(String username,String password) throws InterruptedException {
		//System.out.println("Clicked Successfully");
		
		driver.findElement(By.id(loc.getProperty("email_field"))).sendKeys(username);
		driver.findElement(By.id(loc.getProperty("password_field"))).sendKeys(password);
		driver.findElement(By.xpath(loc.getProperty("login_button"))).click();
		//driver.findElement(By.xpath(loc.getProperty("seeall_friend_requests"))).click();
		driver.findElement(By.xpath(loc.getProperty("profile_account"))).click();
		driver.findElement(By.xpath(loc.getProperty("MoveTo_Profile"))).click();
	}
	
	
}



