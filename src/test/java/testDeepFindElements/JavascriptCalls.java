package testDeepFindElements;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class JavascriptCalls {
	String ChromePath = System.getProperty("user.dir") + "\\resources\\chromedriver.exe";
	WebDriver chromeDriver;
	String URL = "https://www.google.com/";
	String URL2 = "https://www.amazon.com/";
	
	@BeforeTest
	public void openURL() {
		System.setProperty("webdriver.chrome.driver", ChromePath);
		chromeDriver = new ChromeDriver();
		chromeDriver.navigate().to(URL2);
	}
	@Test(enabled = false)
	public void testJSExecutor() throws InterruptedException
	{
		//Creating the JavascriptExecutor interface object by Type casting
		JavascriptExecutor js = (JavascriptExecutor) chromeDriver;
		
		//Find search input
		WebElement seachTxt = chromeDriver.findElement(By.name("q"));
		seachTxt.sendKeys("selenium");

		//Find Search button
		WebElement seachBtn = chromeDriver.findElement(By.name("btnK"));
		//Perform Click on Search button using JavascriptExecutor		
        js.executeScript("arguments[0].click();", seachBtn);
        
        String title = (String) js.executeScript("var title = document.title; return title;");
        System.out.print(title);
        
      //Write Javascript script to be executed inside JavascriptExecutor
        long links =   (Long) js.executeScript("var x = document.getElementsByTagName('A'); return x.length;");
        assertEquals(links, 138);
		
	}
	@Test
	public void testJSExecutorScroll() throws InterruptedException
	{
		//Maximize window		
		chromeDriver.manage().window().maximize();
		//Creating the JavascriptExecutor interface object by Type casting
		JavascriptExecutor js = (JavascriptExecutor) chromeDriver;
		 //Vertical scroll down by 600  pixels		
        js.executeScript("window.scrollBy(0,600)");
        Thread.sleep(2000);
	}
	@AfterTest
	public void closeDriver() {
		chromeDriver.quit();
	}

}
