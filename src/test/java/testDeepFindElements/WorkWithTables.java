package testDeepFindElements;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.awt.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class WorkWithTables {
	String ChromePath = System.getProperty("user.dir") + "\\resources\\chromedriver.exe";
	WebDriver chromeDriver;
	String URL = "https://the-internet.herokuapp.com/tables";
	
	
	@BeforeTest
	public void openURL() {
		System.setProperty("webdriver.chrome.driver", ChromePath);
		chromeDriver = new ChromeDriver();
		chromeDriver.navigate().to(URL);

	}
	@Test
	public void getSpecificData() throws InterruptedException {
		WebElement firstCell = chromeDriver.findElement(By.xpath("//*[@id=\"table1\"]/tbody/tr[1]/td[1]"));
		firstCell.getText();
		System.out.print(firstCell.getText());
	}
	@Test
	public void getAllData() throws InterruptedException {
		//Access the first table
		WebElement table1 = chromeDriver.findElement(By.id("table1"));
		//Find rows of the first table
		java.util.List<WebElement> rows = table1.findElements(By.tagName("tr"));
		//Verify on numbers of rows
		assertEquals(rows.size(), 5);
		
		for(WebElement row :rows)
		{
			
			java.util.List<WebElement> cols = row.findElements(By.tagName("td"));
			for(WebElement col:cols)
				System.out.print(col.getText()+"\t"); 
			System.out.print("\r"); 
		}
		
		
	}
	@AfterTest
	public void closeDriver() {
		chromeDriver.quit();
	}

}
