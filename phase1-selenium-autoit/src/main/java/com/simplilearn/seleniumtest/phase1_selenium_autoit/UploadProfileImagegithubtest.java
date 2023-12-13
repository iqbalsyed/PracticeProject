package com.simplilearn.seleniumtest.phase1_selenium_autoit;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class UploadProfileImagegithubtest {

	static WebDriver driver = null;
	public static void main(String[] args) throws InterruptedException {
		setUp();
		login();
		try {
			uploadProfile();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
				
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
    	driver.findElement(By.id("login_field")).sendKeys(Login.username);
    	driver.findElement(By.id("password")).sendKeys(Login.password);
    	driver.findElement(By.xpath("/html/body/div[1]/div[3]/main/div/div[4]/form/div/input[13]")).submit();
    	
    }
    public static void uploadProfile() throws IOException, InterruptedException {
    	        // redirect to profile page
    			String siteUrl = "https://github.com/settings/profile";
    			driver.get(siteUrl);
    			
    			// click on profile edit
    			driver.findElement(By.xpath("//*[@id=\"settings-frame\"]/div[2]/div[2]/dl/dd/div/details/summary/div")).click();
    			
    			// click on upload photo 
    			driver.findElement(By.xpath("//*[@id=\"settings-frame\"]/div[2]/div[2]/dl/dd/div/details/details-menu/label")).click();
    			
    			
    			Thread.sleep(3000);
    			
    			// run autoit exe file 
    			Runtime.getRuntime().exec("autoit\\upload-profile.exe");
    			
    			
    			Thread.sleep(3000);
    			
    			// click on final submit
    			driver.findElement(By.xpath("//*[@id=\"avatar-crop-form\"]/div[2]/button")).click();
		
	}
   }


