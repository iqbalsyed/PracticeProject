package Chrome;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class TicketChecking {
	// WebDriver driver = new RemoteWebDriver(URLof hub,capabilties )
	WebDriver driver;
		
		@BeforeClass
		public void setUp() throws MalformedURLException
		{
		// Write the desired configuration where the script has to run
			
			 ChromeOptions cap = new ChromeOptions();
				
				driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"),cap);
		}
		
		@Test
		public void test1()
		{
			
			driver.get("https://www.redbus.in");
			driver.findElement(By.xpath("//*[@id=\"src\"]")).sendKeys("Chennai");
			driver.findElement(By.xpath("//*[@id=\"dest\"]")).sendKeys("Kolkata");
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			driver.findElement(By.id("search_button")).click();
		}
		
		
		
	   @AfterClass
	   public void closesession()
	   {
		   driver.quit();
	   }

}
