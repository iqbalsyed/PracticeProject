package com.simplilearn.testng;

import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import static org.testng.Assert.assertEquals;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Iterator;
import java.util.Set;

import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.testng.annotations.AfterClass;

public class starhealth001 {
	
	// step1: formulate a test domain url & driver path
	String siteUrl = "https://www.starhealth.in/";
	String driverPath = "drivers/geckodriver.exe";
	WebDriver driver;
	ExtentSparkReporter htmlReporter;
	ExtentReports extentReports;
	ExtentTest test1, test2, test3, test4, test5 ;
	// create xlsx reference
	XSSFWorkbook workbook;
	XSSFSheet sheet;
	XSSFCell cell;
	
	@BeforeClass
	public void beforeClass() {
		
		htmlReporter = new ExtentSparkReporter("extentReport.html");
		extentReports = new ExtentReports();
		extentReports.attachReporter(htmlReporter);


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
		extentReports.flush();
	}
	
	@Test (description = "alt value of the star health logo ")
	public void test1() throws InterruptedException {
		test1 = extentReports.createTest("Alt value of Star Health Logo");
		test1.log(Status.INFO, "Starting test case");
		String alt = driver.findElement(By.xpath("//*[@id=\"__next\"]/div/div/header/div[2]/div[1]/span/span/img")).getAttribute("alt");
		String expectedalt = "Star Health Logo";
		assertEquals(alt, expectedalt);
		test1.log(Status.INFO, "End test case");
		//Thread.sleep(2000);
	}
	
	@Test (description = "details filling ")
	//@Parameters({"name" , "mobile" , "pin" })
	public void test2() throws InterruptedException {
		test2 = extentReports.createTest("Details Filing");
		test2.log(Status.INFO, "Starting test case");
		driver.findElement(By.xpath("//*[@id=\"__next\"]/div/div/header/div[2]/div[1]/div[2]/div[1]/div[1]/div[1]/p")).click();
		driver.findElement(By.xpath("//*[@id=\"__next\"]/div/div/header/div[2]/div[1]/div[2]/div[1]/div[1]/div[2]/div/div/div/div[2]/div/div/div[1]/div[1]/div[3]")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@id=\"name\"]")).sendKeys("manisha");
		driver.findElement(By.xpath("//*[@id=\"phoneNumber\"]")).sendKeys("9931348475");
		driver.findElement(By.xpath("//*[@id=\"pinCode\"]")).sendKeys("711101");
		test2.log(Status.INFO, "End test case");
		
	}
	@Test (description = "validate data by excelsheet ")
	public void test3() throws InterruptedException {
		test3 = extentReports.createTest("validate data by excelsheet");
		test3.log(Status.INFO, "Starting test case");
		try {
			// Import xlsx sheet
			File src = new File("Validator\\validator.xlsx");

			// Load the file as FileInputStream.
			FileInputStream fileInput = new FileInputStream(src);

			// Load the workbook
			workbook = new XSSFWorkbook(fileInput);

			// Load the sheet in which data is stored. (0)
			sheet = workbook.getSheetAt(0);

			for (int row = 1; row < sheet.getLastRowNum(); row++) {
				// import data from cell : name
				cell = sheet.getRow(row).getCell(1);
				cell.setCellType(CellType.STRING);
				String actualname = driver.findElement(By.xpath("//*[@id=\"name\"]")).getText();
				assertEquals(actualname, cell.getStringCellValue());
				//driver.findElement(By.name("user_login")).sendKeys(cell.getStringCellValue());

				// import data from cell : phonenumber
				cell = sheet.getRow(row).getCell(2);
				cell.setCellType(CellType.STRING);
				String actualnum = driver.findElement(By.xpath("//*[@id=\"phoneNumber\"]")).getText();
				assertEquals(actualnum, cell.getStringCellValue());
				//driver.findElement(By.name("user_pwd")).sendKeys(cell.getStringCellValue());
				
				//import data from cell : pincode
				cell = sheet.getRow(row).getCell(3);
				cell.setCellType(CellType.STRING);
				String actualpin = driver.findElement(By.xpath("//*[@id=\"pinCode\"]")).getText();
				assertEquals(actualpin, cell.getStringCellValue());
				}
			}catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
		test3.log(Status.INFO, "End test case");
	}
	@Test (description = "social media logo ")
	public void test4() throws InterruptedException {
		test4 = extentReports.createTest("Social media logo verification");
		test4.log(Status.INFO, "Starting test case");
		driver.findElement(By.xpath("/html/body/div[1]/div/div/header/div[2]/div[1]/span/span/img")).click();
		Thread.sleep(2000);
		JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,document.body.scrollHeight)");
        String fb = driver.findElement(By.xpath("/html/body/div[1]/div/div/footer/div/div[2]/div[1]/div[2]/a[1]")).getAttribute("href");
        String yt = driver.findElement(By.xpath("/html/body/div[1]/div/div/footer/div/div[2]/div[1]/div[2]/a[2]")).getAttribute("href");
        String li = driver.findElement(By.xpath("/html/body/div[1]/div/div/footer/div/div[2]/div[1]/div[2]/a[3]")).getAttribute("href");
        String tw = driver.findElement(By.xpath("/html/body/div[1]/div/div/footer/div/div[2]/div[1]/div[2]/a[4]")).getAttribute("href");
        String in = driver.findElement(By.xpath("/html/body/div[1]/div/div/footer/div/div[2]/div[1]/div[2]/a[5]")).getAttribute("href");
        try {
			File src = new File("Validator\\socialmedia.xlsx");
			FileInputStream fileInput = new FileInputStream(src);
			workbook = new XSSFWorkbook(fileInput);
			sheet = workbook.getSheetAt(0);

			for (int row = 1; row < sheet.getLastRowNum(); row++) {
				// import data from cell : fb
				cell = sheet.getRow(row).getCell(1);
				cell.setCellType(CellType.STRING);
				assertEquals(fb, cell.getStringCellValue());

				// import data from cell : yt
				cell = sheet.getRow(row).getCell(2);
				cell.setCellType(CellType.STRING);
				assertEquals(yt, cell.getStringCellValue());
				
				//import data from cell : li
				cell = sheet.getRow(row).getCell(3);
				cell.setCellType(CellType.STRING);
				assertEquals(li, cell.getStringCellValue());
				
				//import data from cell : tw
				cell = sheet.getRow(row).getCell(4);
				cell.setCellType(CellType.STRING);
				assertEquals(tw, cell.getStringCellValue());
				
				//import data from cell : in
				cell = sheet.getRow(row).getCell(5);
				cell.setCellType(CellType.STRING);
				assertEquals(in, cell.getStringCellValue());
				}
			}catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
        test4.log(Status.INFO, "End test case");
	}
	@Test (description = "twitter scenario ")
	public void test5() throws InterruptedException {
		test5 = extentReports.createTest("twitter Scenario");
		test5.log(Status.INFO, "Starting test case");
		String clicklnk = Keys.chord(Keys.CONTROL,Keys.ENTER);
		driver.findElement(By.xpath("/html/body/div[1]/div/div/footer/div/div[2]/div[1]/div[2]/a[4]")).sendKeys(clicklnk);;
		Thread.sleep(2000);
		String urlcheck = driver.getCurrentUrl();
		boolean result = urlcheck.contains("starhealth");
		assertEquals(result, true);
		 Set<String> allTabs = driver.getWindowHandles();
	       
	        // Get Current tab
	        String currentTab = driver.getWindowHandle();
	       
	        Iterator<String> iterator = allTabs.iterator();
	       
	        while(iterator.hasNext()) {
	            // Condition to check if the selected tab is not current tab
	            String selectedTab = iterator.next();
	            if(!selectedTab.equals(currentTab)) {
	                driver.switchTo().window(selectedTab);
	                System.out.println("Closing Tab = "+driver.getTitle());
	                Thread.sleep(2000);
	                driver.close();
	                Thread.sleep(1000);
	            }
	        }
	        test5.log(Status.INFO, "End test case");
	}
	
		
}
