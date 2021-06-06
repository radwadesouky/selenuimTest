package testDeepFindElements;

import static org.testng.Assert.assertEquals;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class HandlingCookies {
	String ChromePath = System.getProperty("user.dir") + "\\resources\\chromedriver.exe";
	WebDriver chromeDriver;
	String URL = "http://magento-demo.lexiconn.com/";

	@BeforeTest
	public void openURL() {
		System.setProperty("webdriver.chrome.driver", ChromePath);
		chromeDriver = new ChromeDriver();
		chromeDriver.navigate().to(URL);
	}
	@Test
	public void testCookies()
	{
		WebElement lang = chromeDriver.findElement(By.id("select-language"));
		Select options = new Select(lang);
		//Store cookie should be null
		Cookie storeCookie = chromeDriver.manage().getCookieNamed("store");
		//Verify there wasn't set for cookie
		assertEquals(null, storeCookie);
		//Select German language 
		options.selectByVisibleText("German");
		//Store cookie should be populated with selected country
		 storeCookie = chromeDriver.manage().getCookieNamed("store");
		//Verify that cookie became German
		 assertEquals("german", storeCookie.getValue());
		 
		 //Get names of all cookies on website
		 Set<Cookie> cookieList = chromeDriver.manage().getCookies();
		 for(Cookie list:cookieList)
			 System.out.print(list.getName()+"\n");
		
	}
	@AfterTest
	public void closeDriver() {
		chromeDriver.quit();
	}

}
