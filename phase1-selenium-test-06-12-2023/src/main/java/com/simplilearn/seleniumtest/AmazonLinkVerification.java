package com.simplilearn.seleniumtest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class AmazonLinkVerification {

	static WebDriver driver = null;
	public static void main(String[] args) throws InterruptedException {
		String siteUrl = "https://www.amazon.in";
		String driverPath = "drivers/chromedriver.exe";
		//step2 set system property for selenium driver
		System.setProperty("webdriver.chrome.driver",driverPath);
		//step3  instantiate selenium webdriver
	    driver = new ChromeDriver();
		//step 4 launch browser
		driver.get(siteUrl);
		testSearch();
		testSearch2();
		Thread.sleep(2000);
		driver.close();
  }
	private static void testSearch() {
		WebElement link = driver.findElement(By.xpath("//*[@id=\"nav-xshop\"]/a[4]"));
		link.click();
		//*[@id="nav-xshop"]/a[4]
	}
	private static void testSearch2() {
		WebElement link = driver.findElement(By.cssSelector("#nav-xshop > a:nth-child(6)"));
		link.click();
    }
}
