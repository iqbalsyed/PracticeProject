package com.simplilearn.seleniumtest;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class AmazonHomePage {

	public static void main(String[] args) {
		String siteUrl = "https://www.amazon.in";
		String driverPath = "drivers/chromedriver.exe";
		//step2 set system property for selenium driver
		System.setProperty("webdriver.chrome.driver",driverPath);
		//step3  instantiate selenium webdriver
		WebDriver driver = new ChromeDriver();
		//step 4 launch browser
		driver.get(siteUrl);
		//step 5 evaluate test
		String expectedTitle = "Online Shopping site in India: Shop Online for Mobiles, Books, Watches, Shoes and More - Amazon.in";
		if(expectedTitle.equals(driver.getTitle())) {
			System.out.println("passed");
		}else {
			System.out.println("Failed");
		}
		
	} 
}
