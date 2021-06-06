package testDeepFindElements;

import static org.testng.Assert.assertEquals;

import java.util.HashMap;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.CapabilityType;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class DownloadChrome {
	String ChromePath = System.getProperty("user.dir") + "\\resources\\chromedriver.exe";
	WebDriver chromeDriver;
	String URL = "https://the-internet.herokuapp.com/download";
	static String downloadedPath = System.getProperty("user.dir") + "\\Downloads\\";
	
	public static ChromeOptions chromeoptions()
	{
		ChromeOptions options = new ChromeOptions();
		HashMap<String, Object> chromePrefs = new HashMap<String, Object>();
		chromePrefs.put("profile.default.content_settings.popups", 0);
		chromePrefs.put("download.default_directory", downloadedPath);
		options.setExperimentalOption("prefs", chromePrefs);
		options.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
		return options;
	}
	
	@BeforeTest
	public void setup() {
		System.setProperty("webdriver.chrome.driver", ChromePath);
		chromeDriver = new ChromeDriver(chromeoptions());
		chromeDriver.navigate().to(URL);

	}
	@Test
	public void testDownloadFiles() throws InterruptedException {
     chromeDriver.findElement(By.linkText("webdriverIO.png")).click();
     Thread.sleep(2000);
	}
	@AfterTest
	public void closeDriver() {
		chromeDriver.quit();
	}
}
