package com.SeleniumWebDriver;

import static org.testng.Assert.fail;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TestNG {
	String URL = "http://www.google.com/";
	WebDriver driver ;

	@BeforeTest(groups = {"regression"})
	public void setupDriver() {
		String ChromePath = System.getProperty("user.dir") + "\\resources\\chromedriver.exe";
		System.setProperty("webdriver.chrome.driver", ChromePath);
		driver = new ChromeDriver();
		driver.navigate().to(URL);
	}
	@Test(priority=2,description = "Get title of entered url",groups = {"regression"})
	public void getTitleOfURL() {
		System.out.print("Title = "+driver.getTitle()+"\r\n");
	}
	@Test(priority =1 , enabled = true,dependsOnMethods= {"getTitleOfURL"})
	public void getCurrentURL() {
		System.out.print("Current URL = "+driver.getCurrentUrl()+"\r\n");
		fail("Throw Exception");
	}
	@AfterTest(groups = {"regression"})
	public void closeDriver() {
		driver.quit();
	}
}
