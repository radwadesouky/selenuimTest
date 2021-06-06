package testDeepFindElements;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class DragAndDrop {
	String ChromePath = System.getProperty("user.dir") + "\\resources\\chromedriver.exe";
	WebDriver chromeDriver;
	String URL = "http://cookbook.seleniumacademy.com/DragDropDemo.html";

	@BeforeTest
	public void openURL() {
		System.setProperty("webdriver.chrome.driver", ChromePath);
		chromeDriver = new ChromeDriver();
		chromeDriver.navigate().to(URL);

	}
	@Test
	public void dragAndDropTest() throws InterruptedException
	{
		//Find Source element
		WebElement drag = chromeDriver.findElement(By.id("draggable"));
		//Find target element
		WebElement drop = chromeDriver.findElement(By.id("droppable"));
		//Creating object of Actions class to build composite actions  
		Actions builder = new Actions(chromeDriver);
		//Performs click-and-hold at the location of the source element, 
		//moves to the location of the target element, then releases the mouse.
		builder.dragAndDrop(drag, drop).build().perform();
		Thread.sleep(2000);
		//Verify that text will change after dropping
		assertEquals("Dropped!", drop.getText());
	}
	@AfterTest
	public void closeDriver() {
		chromeDriver.quit();
	}


}
