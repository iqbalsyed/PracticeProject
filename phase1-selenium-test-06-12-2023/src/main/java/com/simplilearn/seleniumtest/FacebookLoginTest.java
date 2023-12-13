package com.simplilearn.seleniumtest;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class FacebookLoginTest {

	static WebDriver driver = null;
	static WebDriverWait wait;
	public static void main(String[] args) throws InterruptedException {
		
		setUp();
		testfailureLogin();
		
	}
	public static void setUp() {
		String siteUrl = "https://www.facebook.com";
		String driverPath = "drivers/chromedriver.exe";
		//step2 set system property for selenium driver
		System.setProperty("webdriver.chrome.driver",driverPath);
		//step3  instantiate selenium webdriver
	    driver = new ChromeDriver();
		//step 4 launch browser
		
		wait = new WebDriverWait(driver,Duration.ofSeconds(20));

		driver.get(siteUrl);
	}
	public static void testfailureLogin() {
		driver.findElement(By.id("email")).sendKeys("abc@gmail.com");
		driver.findElement(By.id("pass")).sendKeys("12456");
		driver.findElement(By.name("login")).submit();
		
	}
}
