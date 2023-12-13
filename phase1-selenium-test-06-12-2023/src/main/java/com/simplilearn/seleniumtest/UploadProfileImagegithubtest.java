package com.simplilearn.seleniumtest;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class UploadProfileImagegithubtest {

	static WebDriver driver = null;
	public static void main(String[] args) throws InterruptedException {
		setUp();
				
  }
    public static void setUp() {
		String siteUrl = "https://www.github.com/login";
		String driverPath = "drivers/chromedriver.exe";
		//step2 set system property for selenium driver
		System.setProperty("webdriver.chrome.driver",driverPath);
		//step3  instantiate selenium webdriver
	    driver = new ChromeDriver();
		//step 4 launch browser
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

		driver.get(siteUrl);
	}
    public static void login() {
    	// find fields and enter credentials
    	driver.findElement(By.id("login_field")).sendKeys("Login@abcd.com");
    	driver.findElement(By.id("password")).sendKeys("Login@password");
    	driver.findElement(By.xpath("/html/body/div[1]/div[3]/main/div/div[4]/form/div/input[13]")).submit();
    	
    }
   }


