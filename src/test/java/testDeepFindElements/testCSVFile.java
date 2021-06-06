package testDeepFindElements;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;

import data.ExcelReader;

public class testCSVFile {
	String ChromePath = System.getProperty("user.dir") + "\\resources\\chromedriver.exe";
	WebDriver chromeDriver;
	String URL = "http://cookbook.seleniumacademy.com/Locators.html";

	//CSV Data
	CSVReader reader ;
	String filePath = System.getProperty("user.dir")+"/src/test/java/data/data.csv";

	@BeforeTest
	public void openURL() {
		System.setProperty("webdriver.chrome.driver", ChromePath);
		chromeDriver = new ChromeDriver();
		chromeDriver.navigate().to(URL);
	}
	@Test
	public void search() throws InterruptedException, CsvValidationException, IOException
	{
		//get data file 
		try {
			reader = new CSVReader(new FileReader(filePath));
		} catch (FileNotFoundException e) {
			System.out.print("CSV file is not found !!");
		}
		String[] csvCell;
		while((csvCell=reader.readNext())!=null)
		{
			WebElement seachTxt = chromeDriver.findElement(By.id("tags"));
			seachTxt.clear();
			String keywork = csvCell[0];
			seachTxt.sendKeys(keywork);
			Thread.sleep(2000);
			seachTxt.clear();
		}

	}
	@AfterTest
	public void closeDriver() {
		chromeDriver.quit();
	}
}
