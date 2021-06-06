package testDeepFindElements;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.github.javafaker.Faker;

import data.ExcelReader;

public class testDDTUsingFakeLibraries {
	String ChromePath = System.getProperty("user.dir") + "\\resources\\chromedriver.exe";
	WebDriver chromeDriver;
	String URL = "http://cookbook.seleniumacademy.com/Locators.html";
	Faker faker = new Faker();
	String keyword = faker.internet().emailAddress(); 

	@BeforeTest
	public void openURL() {
		System.setProperty("webdriver.chrome.driver", ChromePath);
		chromeDriver = new ChromeDriver();
		chromeDriver.navigate().to(URL);
	}
	@Test
	public void promptAlerts() throws InterruptedException
	{
		WebElement seachTxt = chromeDriver.findElement(By.id("tags"));
		seachTxt.sendKeys(keyword);
		Thread.sleep(2000);
		seachTxt.clear();
	}
	@AfterTest
	public void closeDriver() {
		chromeDriver.quit();
	}

}
