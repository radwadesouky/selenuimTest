package testDeepFindElements;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class WorkWithCheckboxesAndRadioButtons {
	String ChromePath = System.getProperty("user.dir") + "\\resources\\chromedriver.exe";
	WebDriver chromeDriver;
	String URL = "https://the-internet.herokuapp.com/checkboxes";
	String URL2 = "http://demo.guru99.com/test/radio.html";
	
	@BeforeTest
	public void openURL() {
		System.setProperty("webdriver.chrome.driver", ChromePath);
		chromeDriver = new ChromeDriver();
		chromeDriver.navigate().to(URL);

	}
	@Test(enabled = false)
	public void testCheckbox() throws InterruptedException {
		//Find checkbox item 2 element from page
		WebElement checkBoxitem2 = chromeDriver.findElement(By.xpath("//*[@id=\"checkboxes\"]/input[2]"));
		assertTrue(checkBoxitem2.isSelected());
		WebElement checkBoxitem1 = chromeDriver.findElement(By.xpath("//*[@id=\"checkboxes\"]/input[1]"));
		checkBoxitem1.click();
		Thread.sleep(2000);
		assertTrue(checkBoxitem1.isSelected());
		
	}
	@Test
	public void testRadioButtons() throws InterruptedException {
		//Find radio item 1 from page
		WebElement radioButtonItem1 = chromeDriver.findElement(By.id("vfb-7-1"));
		radioButtonItem1.click();
		Thread.sleep(2000);
		WebElement radioButtonItem2 = chromeDriver.findElement(By.id("vfb-7-2"));
		radioButtonItem2.click();
		Thread.sleep(2000);
		assertTrue(radioButtonItem2.isSelected());
		
	}
	@AfterTest
	public void closeDriver() {
		chromeDriver.quit();
	}

}
