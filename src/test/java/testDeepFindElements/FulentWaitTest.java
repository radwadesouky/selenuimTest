package testDeepFindElements;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class FulentWaitTest {
	String ChromePath = System.getProperty("user.dir") + "\\resources\\chromedriver.exe";
	WebDriver chromeDriver;
	String URL = "http://cookbook.seleniumacademy.com/AjaxDemo.html";
	@BeforeTest
	public void openURL() {
		System.setProperty("webdriver.chrome.driver", ChromePath);
		chromeDriver = new ChromeDriver();
		chromeDriver.navigate().to(URL);
	}
	
	@Test
	public void testFulentWait()
	{
		//Get hyperlink for page 4 
		WebElement hyperLinkPage4 = chromeDriver.findElement(By.linkText("Page 4"));
		hyperLinkPage4.click();
		
		//Declare and initialize a fluent wait , Specify the timeout of the wait , 
		/*Wait<WebDriver> fWait = new FluentWait<WebDriver> (chromeDriver)
				.withTimeout(20, TimeUnit.SECONDS)
				.pollingEvery(2, TimeUnit.SECONDS)
				.ignoring(NoSuchElementException.class);
		
				   WebElement message = fWait.until(new Function<WebDriver, WebElement>() {
				     public WebElement apply(WebDriver chromeDriver) {
				       return chromeDriver.findElement(By.id("page4"));
				     }
				   });*/
	}
	@AfterTest
	public void closeDriver() {
		chromeDriver.quit();
	}



}
