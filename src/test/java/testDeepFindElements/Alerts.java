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

public class Alerts {
	String ChromePath = System.getProperty("user.dir") + "\\resources\\chromedriver.exe";
	WebDriver chromeDriver;
	String URL = "http://cookbook.seleniumacademy.com/Alerts.html";

	@BeforeTest
	public void openURL() {
		System.setProperty("webdriver.chrome.driver", ChromePath);
		chromeDriver = new ChromeDriver();
		chromeDriver.navigate().to(URL);

	}
	@Test(enabled = false)
	public void simpleAlerts() throws InterruptedException
	{
	 WebElement showBtn = chromeDriver.findElement(By.id("simple"));
	 showBtn.click();
	 //Swithching to alert
	 Alert alert = chromeDriver.switchTo().alert();
	 //Get alert message to verify on it
	 String alertMsg = alert.getText();
	 assertEquals("Hello! I am an alert box!", alertMsg);
	 //This method is used to click on the 'Ok' button of the alert.
	 alert.accept();
	 Thread.sleep(2000);
	}
	@Test
	public void promptAlerts() throws InterruptedException
	{
	 WebElement promptBtn = chromeDriver.findElement(By.id("prompt"));
	 promptBtn.click();
	 //Swithching to alert
	 Alert alert = chromeDriver.switchTo().alert();
	 //This method is used to send some data to the alert box
	 alert.sendKeys("Radwa");
	 //This method is used to click on the 'Ok' button of the alert.
	 alert.accept();
	 //Get alert message to verify on it
	 WebElement message = chromeDriver.findElement(By.id("prompt_demo"));
	 assertEquals(message.getText(), "Hello Radwa! How are you today?");
	 Thread.sleep(2000);
	}
	@AfterTest
	public void closeDriver() {
		chromeDriver.quit();
	}

}
