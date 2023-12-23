package Firefox;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class HomePageTest {
	// WebDriver driver = new RemoteWebDriver(URLof hub,capabilties )
	WebDriver driver;
		
		@BeforeClass
		public void setUp() throws MalformedURLException
		{
		// Write the desired configuration where the script has to run
			
			DesiredCapabilities cap = null;
			cap = new DesiredCapabilities();
			cap.setPlatform(Platform.WINDOWS);
			//driver = new FirefoxDriver();
			cap.setBrowserName("firefox");
			
			driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"),cap);
		}
		
		@Test
		public void test1()
		{
			driver.get("https://www.redbus.in");
			String expectedTitle="Online Bus Ticket Booking with Best Offers and Lowest Price - redBus";
			String ActualTitle = driver.getTitle();
			Assert.assertEquals(ActualTitle, expectedTitle);
		}
		
	   @AfterClass
	   public void closesession()
	   {
		   driver.quit();
	   }

}
