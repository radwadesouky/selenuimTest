package testDeepFindElements;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class MultipleWindows {
	String ChromePath = System.getProperty("user.dir") + "\\resources\\chromedriver.exe";
	WebDriver chromeDriver;
	String URL = "http://cookbook.seleniumacademy.com/Config.html";

	@BeforeTest
	public void openURL() {
		System.setProperty("webdriver.chrome.driver", ChromePath);
		chromeDriver = new ChromeDriver();
		chromeDriver.navigate().to(URL);
	}

	@Test(enabled = false)
	public void openVisitWindow() throws InterruptedException {
		// This will handle the current window that uniquely identifies it within this
		// driver instance
		String currentWindowID = chromeDriver.getWindowHandle();
		// Find visit page button
		WebElement visitBtn = chromeDriver.findElement(By.id("visitbutton"));
		visitBtn.click();

		// To handle all opened windows by web driver
		for (String windowID : chromeDriver.getWindowHandles()) {
			String title = chromeDriver.switchTo().window(windowID).getTitle();
			if (title == "Visit Us") {
				chromeDriver.close();
				break;
			}
		}
		chromeDriver.switchTo().window(currentWindowID);

	}

	//Access multiple windows using another way by access ID of window
	@Test
	public void openHelpWindow() throws InterruptedException {
		// This will handle the current window that uniquely identifies it within this
		// driver instance
		String currentWindowID = chromeDriver.getWindowHandle();
		// Find visit page button
		WebElement helpBtn = chromeDriver.findElement(By.id("helpbutton"));
		helpBtn.click();

		// To get help window using its id 
		String title = chromeDriver.switchTo().window("HelpWindow").getTitle();
		assertEquals(title, "Help");
		Thread.sleep(2000);
		chromeDriver.close();
		chromeDriver.switchTo().window(currentWindowID);

	}

	@AfterTest
	public void closeDriver() {
		chromeDriver.quit();
	}

}
