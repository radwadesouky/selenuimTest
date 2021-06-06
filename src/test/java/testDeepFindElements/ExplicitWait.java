package testDeepFindElements;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class ExplicitWait {
	String ChromePath = System.getProperty("user.dir") + "\\resources\\chromedriver.exe";
	WebDriver chromeDriver;
	String URL = "https://www.google.com/";

	@BeforeTest
	public void openURL() {
		System.setProperty("webdriver.chrome.driver", ChromePath);
		chromeDriver = new ChromeDriver();
		chromeDriver.navigate().to(URL);
	}
	
	@SuppressWarnings("deprecation")
	@Test
	public void testExplicityWait()
	{
		WebElement seachTxt = chromeDriver.findElement(By.name("q"));
		seachTxt.sendKeys("selenium");
		seachTxt.submit();
		
		WebDriverWait wait = new WebDriverWait(chromeDriver,20);
		wait.until(ExpectedConditions.titleContains("selenium"));
		assertTrue(chromeDriver.getTitle().startsWith("selenium"));
	}
	@AfterTest
	public void closeDriver() {
		chromeDriver.quit();
	}


}
