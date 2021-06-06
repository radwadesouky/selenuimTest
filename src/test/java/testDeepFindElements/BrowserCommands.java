package testDeepFindElements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class BrowserCommands {
	String ChromePath = System.getProperty("user.dir") + "\\resources\\chromedriver.exe";
	WebDriver chromeDriver;
	String URL2 = "https://the-internet.herokuapp.com/login";
	String URL = "https://the-internet.herokuapp.com";

	@BeforeTest
	public void openURL() {
		System.setProperty("webdriver.chrome.driver", ChromePath);
		chromeDriver = new ChromeDriver();
		chromeDriver.navigate().to(URL);

	}

	@Test
	public void browserNavigationCommands() {
		try {
			//Navigate to login page
			chromeDriver.navigate().to(URL2);
			//Return back to home page
			chromeDriver.navigate().back();
			//Forward to login page again
			chromeDriver.navigate().forward();
			//After forwarding to login page , will refresh page
			chromeDriver.navigate().refresh();
			
		}
		catch (Exception e) {
			System.out.print(e.getMessage());
		}
	}
	@Test
	public void browserWindowCommands() {
		try {
			//Maximize the window
			chromeDriver.manage().window().maximize();
			//Minimize the window
			chromeDriver.manage().window().minimize();
			//Get the dimensions the window
			chromeDriver.manage().window().getSize();
			System.out.print("Size of window = "+chromeDriver.manage().window().getSize());
			
		}
		catch (Exception e) {
			System.out.print(e.getMessage());
		}
	}
	@AfterTest
	public void closeDriver() {
		chromeDriver.quit();
	}
}
