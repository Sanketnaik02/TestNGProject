package com.ninja.qa.testcases;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.sql.Driver;
import java.util.Date;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.ninja.qa.base.Base;
import com.ninja.qa.utilities.Utility;

import net.bytebuddy.build.Plugin.Factory.UsingReflection.Priority;

import org.testng.Assert;

public class Login  extends Base {

	WebDriver driver;

	@BeforeMethod
	public void OpenBrowser() {
		loadPropertiesFile();
		driver = initializeBroswerAndOpenURL(prop.getProperty("broswerName"));
		// click on My Account DropDown Button
		driver.findElement(By.xpath("//span[text ()='My Account']")).click();

		// click on Login
		driver.findElement(By.linkText("Login")).click();
	}

	@Test(priority = 1)
	public void verifyLoginwithValidCredentials() {

		// Test Case 1 Valid Credentials

		// Valid Email
		WebElement email = driver.findElement(By.id("input-email"));

		email.sendKeys(prop.getProperty("validEmailId"));

		// Valid Password
		WebElement password = driver.findElement(By.id("input-password"));

		password.sendKeys(prop.getProperty("validPassword"));

		// Login
		driver.findElement(By.xpath("//input[contains(@type,'submit')]")).click();

		Assert.assertTrue(driver.findElement(By.linkText("Edit your account information")).isDisplayed(),
				"Elemnet is not Displayed");

		driver.navigate().back();
	}

	@Test(priority = 2)
	public void verifyLoginwithInvalidCredentials() throws InterruptedException {

		// Test Case 2 InValid Credentials

		// InValid Email
		WebElement email = driver.findElement(By.id("input-email"));

		email.sendKeys(Utility.EmailgeneratedDateTime());

		// InValid Password
		WebElement password = driver.findElement(By.id("input-password"));

		password.sendKeys("xyzabc123");

		// Login
		driver.findElement(By.xpath("//input[contains(@type,'submit')]")).click();

		String actucalWarningText = driver.findElement(By.xpath("//div[contains (@class,'alert-dismissible')]"))
				.getText();
		String expectedWarningText = "Warning: No match for E-Mail Address and/or Password.";

		Assert.assertTrue(actucalWarningText.contains(expectedWarningText), "Expected Warning: Not Displayed");
		System.out.println(actucalWarningText);
	}

	@Test(priority = 3)
	public void verifyInvalidEmailAndValidPassword() {
		// Test Case 3 InValid Email and Valid Password

		// InValid Email
		WebElement email = driver.findElement(By.id("input-email"));

		email.sendKeys(Utility.EmailgeneratedDateTime());

		// Valid Password
		WebElement password = driver.findElement(By.id("input-password"));

		password.sendKeys(prop.getProperty("validPassword"));

		// Login
		driver.findElement(By.xpath("//input[contains(@type,'submit')]")).click();

		String actucalWarningText = driver.findElement(By.xpath("//div[contains (@class,'alert-dismissible')]"))
				.getText();
		String expectedWarningText = "Warning: No match for E-Mail Address and/or Password.";

		Assert.assertTrue(actucalWarningText.contains(expectedWarningText), "Expected Warning: Not Displayed");
		System.out.println(actucalWarningText);

	}

	@Test(priority = 4)
	public void verifyValidEmailAndInValidPassword() {

		// Test Case 4 Valid Email and InValid Password

		// Valid Email
		WebElement email = driver.findElement(By.id("input-email"));

		email.sendKeys(prop.getProperty("validEmailId"));

		// InValid Password
		WebElement password = driver.findElement(By.id("input-password"));

		password.sendKeys("1234567788");

		// Login
		driver.findElement(By.xpath("//input[contains(@type,'submit')]")).click();

		String actucalWarningText = driver.findElement(By.xpath("//div[contains (@class,'alert-dismissible')]"))
				.getText();
		String expectedWarningText = "Warning: No match for E-Mail Address and/or Password.";

		Assert.assertTrue(actucalWarningText.contains(expectedWarningText), "Expected Warning: Not Displayed");
		System.out.println(actucalWarningText);

	}

	@Test(priority = 5)
	public void verifyWithourProvideCredntials() {

		// Test Case 4 Valid Email and InValid Password

		// Valid Email
		WebElement email = driver.findElement(By.id("input-email"));

		email.sendKeys(prop.getProperty("validEmailId"));

		// InValid Password
		WebElement password = driver.findElement(By.id("input-password"));

		password.sendKeys("");

		// Login
		driver.findElement(By.xpath("//input[contains(@type,'submit')]")).click();

		String actucalWarningText = driver.findElement(By.xpath("//div[contains (@class,'alert-dismissible')]"))
				.getText();
		String expectedWarningText = "Warning: No match for E-Mail Address and/or Password.";

		Assert.assertTrue(actucalWarningText.contains(expectedWarningText), "Expected Warning: Not Displayed");
		System.out.println(actucalWarningText);

	}

	@AfterMethod
	public void TearDown() {

		driver.close();
	}
}
