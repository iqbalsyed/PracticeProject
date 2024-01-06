package com.simplilearn.testng;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import java.util.List;

public class starhealth002 {
	
	// step1: formulate a test domain url & driver path
		String siteUrl = "https://www.starhealth.in/";
		String driverPath = "drivers/geckodriver.exe";
		WebDriver driver;
		
		

		@BeforeClass
		public void beforeClass() {
			

			// step2: set system properties for selenium dirver
			System.setProperty("webdriver.geckodriver.driver", driverPath);
			//set headless driver option to run the test in background.
			FirefoxOptions options = new FirefoxOptions();
	        options.addArguments("==headless");
			// step3: instantiate selenium webdriver
			driver = new FirefoxDriver(options);
			// step4: launch browser
			driver.get(siteUrl);
		}

		@AfterClass
		public void afterClass() {
			driver.quit();
			
		}
		
		@Test (description = "print all links present on the Star Health home page ")
		public void test1() throws InterruptedException {
			driver.manage().window().maximize();
			 List<WebElement> allLinks = driver.findElements(By.tagName("a"));
			 for(WebElement link:allLinks){
				 System.out.println(link.getText() + " - " + link.getAttribute("href"));
				 }

		}

}
