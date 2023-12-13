package com.simplilearn.seleniumtest.phase1_selenium_skiuli;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.sikuli.script.FindFailed;
import org.sikuli.script.Pattern;
import org.sikuli.script.Screen;

public class FileUploadTest {
public static void main(String[] args) throws InterruptedException, FindFailed {
		

		// step1: formulate a test domain url & driver path
		String siteUrl = "C:\\Users\\Predator\\phase1-selenium-skiuli\\static\\document_upload.html";
		String driverPath = "drivers/chromedriver.exe";

		// step2: set system properties for selenium dirver
		System.setProperty("webdriver.chrome.driver", driverPath);

		// step3: instantiate selenium webdriver
		String inputFiePath="C:\\Users\\Predator\\phase1-selenium-skiuli\\skiuli-inputs\\";
		WebDriver driver = new ChromeDriver();
		Screen screen = new Screen();
		
		Pattern pattern = new Pattern(inputFiePath+ "choose-file.png");
		Pattern fileInput = new Pattern(inputFiePath+ "file-text-box.png");
		Pattern openButton = new Pattern(inputFiePath+ "open-button.png");
		
		// make browser window full screen
		driver.manage().window().maximize();
		// step4: launch browser
		driver.get(siteUrl);
		
		Thread.sleep(2000);
		
		screen.click(pattern);
		
		Thread.sleep(2000);
		
		screen.click(fileInput);
		
		screen.type(fileInput, (inputFiePath + "amazon-tv.png") );
		
		Thread.sleep(2000);
		
		screen.click(openButton);
		
	
     }
}
