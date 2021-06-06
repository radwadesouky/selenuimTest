package testDeepFindElements;

import static org.testng.Assert.assertEquals;

import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class ImplicitWait {
	String ChromePath = System.getProperty("user.dir") + "\\resources\\chromedriver.exe";
	WebDriver chromeDriver;
	String URL = "http://cookbook.seleniumacademy.com/AjaxDemo.html";

	@BeforeTest
	public void openURL() {
		System.setProperty("webdriver.chrome.driver", ChromePath);
		chromeDriver = new ChromeDriver();
		chromeDriver.navigate().to(URL);
	}
	@SuppressWarnings("deprecation")
	@Test
	public void testImplicityWait()
	{
		//Set implicit wait for 20 sec to wait loading of page
		chromeDriver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		//Get hyperlink for page 4 
		WebElement hyperLinkPage4 = chromeDriver.findElement(By.linkText("Page 4"));
		hyperLinkPage4.click();
	}
	@AfterTest
	public void closeDriver() {
		chromeDriver.quit();
	}


}
