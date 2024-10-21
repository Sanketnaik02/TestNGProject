package com.ninja.qa.testcases;

import java.util.Base64;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.ninja.qa.base.Base;
import com.ninja.qa.utilities.Utility;

public class Register extends Base {

	WebDriver driver;

	@BeforeMethod
	public void OpenBrowser() {

		driver = initializeBroswerAndOpenURL(prop.getProperty("broswerName"));
		// click on My Account DropDown Button
		driver.findElement(By.xpath("//span[text ()='My Account']")).click();

		// click on Login
		driver.findElement(By.linkText("Register")).click();

	}

	@Test(priority = 1)
	public void verifyRegistringMandatoryFields() {

		// Enter FirstName
		WebElement firstName = driver.findElement(By.id("input-firstname"));
		firstName.sendKeys("Sanket");

		// Enter LasName
		WebElement lastName = driver.findElement(By.id("input-lastname"));
		lastName.sendKeys("Naik");

		// Enter Email Id
		WebElement Email = driver.findElement(By.id("input-email"));
		Email.sendKeys(Utility.EmailgeneratedDateTime());

		// telephone
		WebElement telePhone = driver.findElement(By.id("input-telephone"));
		telePhone.sendKeys("1234567890");

		// Password
		WebElement password = driver.findElement(By.id("input-password"));
		password.sendKeys("Welcome@01");

		// Password
		WebElement Confirmpassword = driver.findElement(By.id("input-confirm"));
		Confirmpassword.sendKeys("Welcome@01");

		// Policy checkBox
		driver.findElement(By.xpath("//input[@type=\"checkbox\"]")).click();

		// Click Coutine Button
		driver.findElement(By.xpath("//input[@type=\'submit\']")).click();

		// verify

		String actualSuccessfulMessage = driver.findElement(By.xpath("//div[@id=\"content\"]/h1")).getText();

		Assert.assertEquals(actualSuccessfulMessage, "Your Account Has Been Created!", "Element is Not Displayed");

	}

	@Test(priority = 2)
	public void verifyRegistringAccountProvidingAllFields() {
		// Verify Registering an Account by providing all the fields
		// Test Case 2

		// Enter FirstName
		WebElement firstName = driver.findElement(By.id("input-firstname"));
		firstName.sendKeys("Sanket");

		// Enter LasName
		WebElement lastName = driver.findElement(By.id("input-lastname"));
		lastName.sendKeys("Naik");

		// Enter Email Id
		WebElement Email = driver.findElement(By.id("input-email"));
		Email.sendKeys(Utility.EmailgeneratedDateTime());

		// telephone
		WebElement telePhone = driver.findElement(By.id("input-telephone"));
		telePhone.sendKeys("1234567890");

		// Password
		WebElement password = driver.findElement(By.id("input-password"));
		password.sendKeys("Welcome@01");

		// Password
		WebElement Confirmpassword = driver.findElement(By.id("input-confirm"));
		Confirmpassword.sendKeys("Welcome@01");

		// Newletter radio button
		driver.findElement(By.xpath("//input[@name='newsletter'][@value='1']")).click();

		// Policy checkBox
		driver.findElement(By.xpath("//input[@type=\"checkbox\"]")).click();

		// Click Coutine Button
		driver.findElement(By.xpath("//input[@type=\'submit\']")).click();

		// verify

		String actualSuccessfulMessage = driver.findElement(By.xpath("//div[@id=\"content\"]/h1")).getText();

		Assert.assertEquals(actualSuccessfulMessage, "Your Account Has Been Created!", "Element is Not Displayed");

	}

	@Test(priority = 3)

	public void verifyNotificationMessageDisplayed() {
		// Verify proper notification messages are displayed for the mandatory fields,
		// when you don't provide any fields in the 'Register Account' page and submit
		// Test CAse 4

		// Click Coutine Button
		driver.findElement(By.xpath("//input[@type=\'submit\']")).click();

		// Check Warning Message
		String ActualWarningMessage = driver.findElement(By.xpath("//div[contains(@class,'alert-dismissible')]"))
				.getText();

		Assert.assertEquals(ActualWarningMessage, "Warning: You must agree to the Privacy Policy!",
				"Warning Message are Note Displayed");

		// FistName Warning Message
		String actualWarningFirstNameMessage = driver
				.findElement(By.xpath("//*[@id='input-firstname']/following-sibling::div")).getText();

		Assert.assertEquals(actualWarningFirstNameMessage, "First Name must be between 1 and 32 characters!",
				"First Name Warning Message are not displayed");

		// Last Name Warning Message
		String actualWarningLastNameMessage = driver
				.findElement(By.xpath("//*[@id='input-lastname']/following-sibling::div")).getText();

		Assert.assertEquals(actualWarningLastNameMessage, "Last Name must be between 1 and 32 characters!",
				"Last Name Warning Message are not displayed");

		// Email Warning Message
		String actualWarningEmailMessage = driver.findElement(By.xpath("//*[@id='input-email']/following-sibling::div"))
				.getText();

		Assert.assertEquals(actualWarningEmailMessage, "E-Mail Address does not appear to be valid!",
				"Email Warning Message are not displayed");

		// TelePhone Warning Message
		String actualWarningTelePhoneMessage = driver
				.findElement(By.xpath("//*[@id='input-telephone']/following-sibling::div")).getText();

		Assert.assertEquals(actualWarningTelePhoneMessage, "Telephone must be between 3 and 32 characters!",
				"TelePhone Warning Message are not displayed");

		// Password Warning Message
		String actualWarningPasswordMessage = driver
				.findElement(By.xpath("//*[@id='input-password']/following-sibling::div")).getText();

		Assert.assertEquals(actualWarningPasswordMessage, "Password must be between 4 and 20 characters!",
				"Password Warning Message are not displayed");

	}

	@Test(priority = 4)
	public void verifyRegistringEnteringDifferentPasswordintoPasswordFields() {
		// Verify Registering an Account by entering different passwords into
		// 'Password' and 'Password Confirm' fields
		// Test Case 8

		// Enter FirstName
		WebElement firstName = driver.findElement(By.id("input-firstname"));
		firstName.sendKeys("Sanket");

		// Enter LasName
		WebElement lastName = driver.findElement(By.id("input-lastname"));
		lastName.sendKeys("Naik");

		// Enter Email Id
		WebElement Email = driver.findElement(By.id("input-email"));
		Email.sendKeys(Utility.EmailgeneratedDateTime());

		// telephone
		WebElement telePhone = driver.findElement(By.id("input-telephone"));
		telePhone.sendKeys("1234567890");

		// Password
		WebElement password = driver.findElement(By.id("input-password"));
		password.sendKeys("12345");

		// Diffrent Confirm Password
		WebElement Confirmpassword = driver.findElement(By.id("input-confirm"));
		Confirmpassword.sendKeys("abcd");

		// Policy checkBox
		driver.findElement(By.xpath("//input[@type=\"checkbox\"]")).click();

		// Click Coutine Button
		driver.findElement(By.xpath("//input[@type=\'submit\']")).click();

		// Verify Password did not match
		String actualPasswordWarningMessage = driver
				.findElement(By.xpath("//input[@id='input-confirm']/following-sibling::div")).getText();

		Assert.assertEquals(actualPasswordWarningMessage, "Password confirmation does not match password!",
				"Password warning message not shown");

	}

	@AfterMethod
	public void TearDown() {
		driver.close();
	}

}
