package com.simplilearn.seleniumtest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class AmazonSearchTest {
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
		//testSearch2();
		Thread.sleep(2000);
		//driver.close();
  }
	private static void testSearch() {
		WebElement mobile = driver.findElement(By.xpath("//*[@id=\"nav-xshop\"]/a[5]"));
		mobile.click();
		WebElement apple = driver.findElement(By.xpath("//*[@id=\"s-refinements\"]/div[6]/ul/li[3]/span/a/span"));
		apple.click();
		WebElement iphone13 = driver.findElement(By.xpath("//*[@id=\"search\"]/div[1]/div[1]/div/span[1]/div[1]/div[4]/div/div/span/div/div/div[1]/span/a/div/img"));
		iphone13.click();
	}
//	private static void testSearch2() {
//		WebElement searchBox = driver.findElement(By.id("twotabsearchtextbox"));
//		searchBox.clear();
//		searchBox.sendKeys("Apple Macbook Pro");
//		searchBox.submit();
//    }
}
