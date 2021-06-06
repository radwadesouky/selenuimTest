package testDeepFindElements;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.awt.Color;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Sleeper;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class DoubleClick {
	String ChromePath = System.getProperty("user.dir") + "\\resources\\chromedriver.exe";
	WebDriver chromeDriver;
	String URL = "http://cookbook.seleniumacademy.com/DoubleClickDemo.html";

	@BeforeTest
	public void openURL() {
		System.setProperty("webdriver.chrome.driver", ChromePath);
		chromeDriver = new ChromeDriver();
		chromeDriver.navigate().to(URL);

	}
	@Test
	public void testDoubleClick() throws InterruptedException
	{
		WebElement message = chromeDriver.findElement(By.id("message"));
		//String color = message.getCssValue("background-color");
		//System.out.print(color);
		//assertTrue(color.contains("rgba(225, 225, 0, 1)"));
		
		//Creating object of Actions class to build composite actions  
		Actions builder = new Actions(chromeDriver);
		//Performs a double-click at the current mouse location.
		builder.doubleClick(message).build().perform();
		Thread.sleep(2000);
		String color = message.getCssValue("background-color");
		//Verify on changing of color of message is yellow after double click
		assertTrue(color.contains("rgba(255, 255, 0, 1)"));
		
	}
	@AfterTest
	public void closeDriver() {
		chromeDriver.quit();
	}

}
