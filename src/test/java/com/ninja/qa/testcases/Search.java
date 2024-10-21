package com.ninja.qa.testcases;

import java.security.PublicKey;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.ninja.qa.base.Base;

public class Search extends Base {

	WebDriver driver;
	@BeforeMethod
	public void BrowserStart() {
		driver = initializeBroswerAndOpenURL(prop.getProperty("broswerName"));
		
	}
	@Test(priority = 1)
	public void verifySearchingWithValidProduct() {
		
		
	}

	@AfterMethod
	public void tearDown() {
		driver.close();
	}

}
