package testDeepFindElements;

import static org.testng.Assert.assertEquals;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class FindElements {

	String ChromePath = System.getProperty("user.dir") + "\\resources\\chromedriver.exe";
	WebDriver chromeDriver;
	String URL = "https://the-internet.herokuapp.com/login";
	String URL2 = "https://the-internet.herokuapp.com";

	@BeforeTest
	public void openURL() {
		System.setProperty("webdriver.chrome.driver", ChromePath);
		chromeDriver = new ChromeDriver();
		chromeDriver.navigate().to(URL2);

	}

	@Test(enabled = false)
	public void findElementsByID() {
		try {
			WebElement userName = chromeDriver.findElement(By.id("username1"));
			WebElement password = chromeDriver.findElement(By.id("password"));
			// assertEquals(password, "password");
		} catch (Exception e) {
			System.out.print("The element is not found");
		}

	}
	@Test(enabled = false)
	public void findElementsByClassName() {
		try {
			WebElement button = chromeDriver.findElement(By.className("radius"));
			System.out.print(button.getText());
			
		} catch (Exception e) {
			System.out.print("The element is not found");
		}

	}
	@Test(enabled = false)
	public void findElementsByTagName() {
		try {
			WebElement button = chromeDriver.findElement(By.tagName("button"));
			System.out.print(button.getText());
			
		} catch (Exception e) {
			System.out.print("The element is not found");
		}

	}
	
	@Test(enabled = false)
	@Parameters("CssSelector")
	public void findElementsByCssSelector(String cssSelector) {
		try {
			WebElement Loginbtn = chromeDriver.findElement(By.cssSelector(cssSelector));
			System.out.print(Loginbtn.getText());
			
		} catch (Exception e) {
			System.out.print("The element is not found");
		}

	}
	
	@Test
	public void findListOfElements() {
		try {
			//Get all links that are displayed on the page
		List<WebElement> links = chromeDriver.findElements(By.tagName("a"));
		
		//Verify on numbers of links on page
		int linksSize = links.size();
		assertEquals(linksSize, 46);
		
		//Print the names of all links
		for(WebElement link :links)
			System.out.print(link.getAttribute("href")+"\r\n");
			
		} catch (Exception e) {
			System.out.print("The element is not found");
		}

	}
	@AfterTest
	public void closeDriver() {
		chromeDriver.quit();
	}

}
