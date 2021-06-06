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

public class WorkWithDropdownList {
	String ChromePath = System.getProperty("user.dir") + "\\resources\\chromedriver.exe";
	WebDriver chromeDriver;
	String URL = "https://the-internet.herokuapp.com/dropdown";

	@BeforeTest
	public void openURL() {
		System.setProperty("webdriver.chrome.driver", ChromePath);
		chromeDriver = new ChromeDriver();
		chromeDriver.navigate().to(URL);

	}
	@Test
	public void testDropDownList() throws InterruptedException {
		//Find dropdownlist element from page
		WebElement dropDownList = chromeDriver.findElement(By.id("dropdown"));
		//The 'Select' class in Selenium WebDriver is used for selecting and deselecting option in a dropdown.
		//The objects of Select type can be initialized by passing the dropdown webElement as parameter to its constructor.
		Select options = new Select(dropDownList);
		//verify that dropdownlist not support select multioptions
		assertFalse(options.isMultiple());
		//verify on numbers of options in dropdownlist
		assertEquals(options.getOptions().size(), 3);
		//select option 1 by value
		options.selectByValue("1");
		Thread.sleep(2000);
		//select option 2 by text
		options.selectByVisibleText("Option 2");
		Thread.sleep(2000);
		
		
	}
	@AfterTest
	public void closeDriver() {
		chromeDriver.quit();
	}
}
