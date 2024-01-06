package com.simplilearn.bddtest.phase2_phaseEnd_Project.stepdefinition;

import static org.testng.AssertJUnit.assertEquals;
import java.io.File;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;

//import com.cucumber.listener.Reporter;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;



public class StarHealth {
	
	String driverPath = "drivers\\chromedriver.exe";
	WebDriver driver;
	WebElement closee;
	ExtentSparkReporter htmlReporter;
	ExtentReports extentReports;
	ExtentTest test1, test2, test3, test4, test5;
	
	@Given("Launch chrome")
	public void launch_chrome() {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
	}

	@When("Enter url {string} and open website")
	public void enter_url_and_open_website(String site_url) {
		String siteUrl = site_url;
		driver.get(siteUrl);
	 
	}

	@Then("Verify page title {string}")
	public void verify_page_title(String page_title) {
		assertEquals(page_title, driver.getTitle());
		driver.close();
	    
	}
	@Given("You are on the website")
	public void you_are_on_the_website() throws IllegalArgumentException {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		String siteUrl = "https://www.starhealth.in/";
		driver.get(siteUrl);
		
	}

	@When("pop up is displayed")
	public void pop_up_is_displayed() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(200));
		wait.until(ExpectedConditions.presenceOfElementLocated(By.id("talktoexpert-form")));
		//alert = wait.until(ExpectedConditions.alertIsPresent());
		
	}

	@Then("close the popup")
	public void close_the_popup() {
		driver.close();
		
	}
	@Given("You are on website")
	public void you_are_on_website() throws IllegalArgumentException {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		String siteUrl = "https://www.starhealth.in/";
		driver.get(siteUrl);
		
	}
	
	@When("locate buy now")
	public void locate_buy_now() {
	    // Write code here that turns the phrase above into concrete actions
		closee = driver.findElement(By.xpath("//*[@id=\"__next\"]/div/div/header/div[2]/div[2]/div"));
	   
	}

	@Then("click on buy now")
	public void click_on_buy_now() {
		closee.click();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(7));
		driver.close();
		
	}
	@When("locate option buy now")
	public void locate_option_buy_now() {
	    // Write code here that turns the phrase above into concrete actions
		closee = driver.findElement(By.xpath("//*[@id=\"__next\"]/div/div/header/div[2]/div[2]/div"));
	   
	}
	@Then("click on option buy now")
	public void click_on_option_buy_now() {
		closee.click();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(7));
		
	}
	
	@When("enter {string} {string} {string} {string} in form")
	public void enter_in_form(String name, String phno, String pin, String email) {
		driver.findElement(By.xpath("//*[@id=\"fullname\"]")).sendKeys(name);
		driver.findElement(By.xpath("//*[@id=\"mobile\"]")).sendKeys(phno);
		driver.findElement(By.xpath("//*[@id=\"zipcode\"]")).sendKeys(pin);
		driver.findElement(By.xpath("//*[@id=\"email\"]")).sendKeys(email);
	}

	@Then("click get started")
	public void click_get_started() {
		driver.findElement(By.xpath("//*[@id=\"userDetails-form\"]/div/div/div/div[1]/div/div/div[2]/div/button")).click();
		driver.close();
	}
	
	@Given("Launch website")
	public void launch_website() throws IllegalArgumentException {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		String siteUrl = "https://www.starhealth.in/";
		driver.get(siteUrl);
		
	}
	
	@When("hover on plans")
	public void hover_on_plans() throws InterruptedException {
	    // Write code here that turns the phrase above into concrete actions
		driver.findElement(By.xpath("//*[@id=\"__next\"]/div/div/header/div[2]/div[1]/div[2]/div[1]/div[1]/div[1]/p")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@id=\"__next\"]/div/div/header/div[2]/div[1]/div[2]/div[1]/div[1]/div[2]/div/div/div/div[2]/div/div/div[1]/div[1]/div[3]/a")).click();
	}

	@Then("click on family plan")
	public void click_on_family_plan() {
		driver.close();
		
	}
	
	@Given("Launch insured")
	public void launch_insured() {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		String siteUrl = "https://web.starhealth.in/customerportal/instant-buy";
		driver.get(siteUrl);
	    
	}

	@When("click on logo")
	public void click_on_logo() {
		driver.findElement(By.xpath("//*[@id=\"hello\"]/header/div/a/img")).click();
		
	}

	@Then("back to mainpage")
	public void back_to_mainpage() {
		String page_title = "Star Health Insurance: Medical, Accident and Travel insurance policies";
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(7));
		assertEquals(page_title, driver.getTitle());
		driver.close();
	    
	}

}
