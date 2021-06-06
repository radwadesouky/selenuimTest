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

import data.ExcelReader;

public class testExcelFile {

	String ChromePath = System.getProperty("user.dir") + "\\resources\\chromedriver.exe";
	WebDriver chromeDriver;
	String URL = "http://cookbook.seleniumacademy.com/Locators.html";

	@DataProvider(name = "keywords")
	public Object[][] setSerachKeywords() throws IOException
	{
		// Get data from excel reader
		ExcelReader data=new ExcelReader();
		return data.getExcelData();
	}
	@BeforeTest
	public void openURL() {
		System.setProperty("webdriver.chrome.driver", ChromePath);
		chromeDriver = new ChromeDriver();
		chromeDriver.navigate().to(URL);
	}
	@Test(dataProvider="keywords")
	public void promptAlerts(String keyword) throws InterruptedException
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
