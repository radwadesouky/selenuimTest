package testDeepFindElements;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class WorkWithTextboxAndButton {

	String ChromePath = System.getProperty("user.dir") + "\\resources\\chromedriver.exe";
	WebDriver chromeDriver;
	String URL2 = "https://the-internet.herokuapp.com/login";
	String URL = "https://the-internet.herokuapp.com";

	@BeforeTest
	public void openURL() {
		System.setProperty("webdriver.chrome.driver", ChromePath);
		chromeDriver = new ChromeDriver();
		chromeDriver.navigate().to(URL2);

	}
	@Test
	public void loginPage() {
		//Get user name text box
		WebElement username = chromeDriver.findElement(By.id("username"));
		//Get password text box
		WebElement password = chromeDriver.findElement(By.id("password"));
		//Get login button
		WebElement loginbtn = chromeDriver.findElement(By.className("radius"));
		//Enter valid username
		username.sendKeys("tomsmith");
		//Enter valid password
		password.sendKeys("SuperSecretPassword!");
		//Click on login button
		loginbtn.click();
		
		//Verify on login is completed
		WebElement successNotification = chromeDriver.findElement(By.id("flash"));
		assertTrue(successNotification.getText().contains("You logged into a secure area"));
	}
	@AfterTest
	public void closeDriver() {
		chromeDriver.quit();
	}
}
