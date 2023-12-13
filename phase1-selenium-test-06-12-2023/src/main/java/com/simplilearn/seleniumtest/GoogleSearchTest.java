package com.simplilearn.seleniumtest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class GoogleSearchTest {

	public static void main(String[] args) {
		//step1 : formulate test domain url & driver path
		String siteUrl = "https://www.google.com";
		String driverPath = "drivers/chromedriver.exe";
		//step2 set system property for selenium driver
		System.setProperty("webdriver.chrome.driver",driverPath);
		//step3  instantiate selenium webdriver
		WebDriver driver = new ChromeDriver();
		//step 4 launch browser
		driver.get(siteUrl);
		//step 5 evaluate test
		WebElement searchBox = driver.findElement(By.name("q"));
		searchBox.sendKeys("selenium documentation");
		searchBox.submit();
		
		String expectedTitle ="selenium documentation - Google Search";
		String actualTitle = driver.getTitle();
		if(expectedTitle.equals(actualTitle)) {
			System.out.println("Test is Passed !");
		}
		else {
			System.out.println("Test is Failed !");
		}
		
		//step 6 close
		driver.close();

	}
}
