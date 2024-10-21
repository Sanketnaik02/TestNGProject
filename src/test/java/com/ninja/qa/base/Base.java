package com.ninja.qa.base;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.lang.classfile.attribute.CompilationIDAttribute;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Base {
	WebDriver driver;
   public Properties prop;
   public Properties prop1;
	public void loadPropertiesFile() {

		prop = new Properties();

		File propFile = new File(
				System.getProperty("user.dir") + "\\src\\main\\java\\com\\ninja\\qa\\config\\config.properties");
		try {
			FileInputStream fis = new FileInputStream(propFile);
			prop.load(fis);
		} catch (Throwable e) {
			// TODO: handle exception

			e.printStackTrace();

		}

	}
	
	public void LoadTestDataFile() {
		 prop1 = new Properties();
		 File propFile1 = new File(System.getProperty("user.dir")+"\\src\\main\\java\\com\\ninja\\qa\\testdata\\testData.xlsx");
		 
		 try {
			 FileInputStream fis1 = new FileInputStream(propFile1);
			 prop1.load(fis1);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		 
		
		
	}
	
	public WebDriver initializeBroswerAndOpenURL(String BroswerName) {
		// Open Broswer
		if (BroswerName.equalsIgnoreCase("chrome")) {
			driver = new ChromeDriver();
		} else if (BroswerName.equalsIgnoreCase("edge")) {
			driver = new EdgeDriver();
		} else if (BroswerName.equalsIgnoreCase("firefox")) {
			driver = new FirefoxDriver();
		} 

		driver.manage().window().maximize();
		// Open URL
		driver.get(prop.getProperty("URL"));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(5));
		
		return driver;
		
	}

}
