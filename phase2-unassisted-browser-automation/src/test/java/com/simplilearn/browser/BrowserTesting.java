package com.simplilearn.browser;

import static org.junit.jupiter.api.Assertions.*;

import java.time.Duration;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
//import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

//@DisplayName("Unit Test")
public class BrowserTesting {

	// step1: formulate a test domain url & driver path
		
		String driverPath = "drivers/geckodriver.exe";
		WebDriver driver;
		
		@BeforeEach
		void setUp() throws Exception {
			// step2: set system properties for selenium dirver
			System.setProperty("webdriver.geckodriver.driver", driverPath);
			//set headless driver option to run the test in background.
			// step3: instantiate selenium webdriver
			driver = new FirefoxDriver();
			// step4: launch browser
			
		}
		@AfterEach
		public void cleanUp() {
			driver.quit();  
			// the quit() method closes all browser windows and ends the WebDriver session.
			// driver.close(); // the close() closes only the current window on which Selenium is running automated tests.The WebDriver session, however, remains active. 
		}
		@Test
		@DisplayName ("Should validate Source Url Facebook")
		public void testSourceUrl() {
			String siteUrl = "https://www.facebook.com/";
			driver.get(siteUrl);
			assertEquals(siteUrl, driver.getCurrentUrl());
		}
		@Test
		@DisplayName("Should validate Title for valid Match Facebook")
		public void testTitle() {
			String siteUrl = "https://www.facebook.com/";
			driver.get(siteUrl);
			String expectedTitle  = "Facebook – log in or sign up";
			String actualTitle  = driver.getTitle();
			assertEquals(actualTitle, expectedTitle);
		}
		@Test
		@DisplayName("Should validate Title for valid Match Google")
		public void testTitleGoogle() {
			String siteUrl = "https://www.google.com/";
			driver.get(siteUrl);
			String expectedTitle  = "Google";
			String actualTitle  = driver.getTitle();
			assertEquals(actualTitle, expectedTitle);
		}
		@Test
		@DisplayName ("Should validate Source Url Google")
		public void testSourceUrlGoogle() {
			String siteUrl = "https://www.google.com/";
			driver.get(siteUrl);
			assertEquals(siteUrl, driver.getCurrentUrl());
		}
		@Test
		@DisplayName ("Should validate search")
		public void testSearch() {
			String siteUrl = "https://www.google.com/";
			driver.get(siteUrl);
			driver.findElement(By.xpath("//*[@id=\"APjFqb\"]")).sendKeys("Facebook");
			driver.findElement(By.xpath("/html/body/div[1]/div[3]/form/div[1]/div[1]/div[4]/center/input[1]")).click();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
			driver.findElement(By.xpath("/html/body/div[5]/div/div[9]/div[1]/div[2]/div[2]/div/div/div[1]/div/div/div/div/div/div/div/div[1]/div/span/a/h3")).click();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
			String expectedTitle  = "Facebook – log in or sign up";
			String actualTitle  = driver.getTitle();
			assertEquals(actualTitle, expectedTitle);
		}
}
