package testDeepFindElements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class ContextMenu {

	String ChromePath = System.getProperty("user.dir") + "\\resources\\chromedriver.exe";
	WebDriver chromeDriver;
	String URL = "https://www.nopcommerce.com/en";	

	@BeforeTest
	public void openURL() {
		System.setProperty("webdriver.chrome.driver", ChromePath);
		chromeDriver = new ChromeDriver();
		chromeDriver.navigate().to(URL);
	}
	@Test
	public void openRegisterPage() {
		//WebElement menu = chromeDriver.findElement(By.cssSelector("body > div.master-wrapper-page > header > div > div.header-links-wrapper > div.header-links > ul > li.usrelinks > a"));
		//WebElement registerLink = chromeDriver.findElement(By.cssSelector("body > div.master-wrapper-page > header > div > div.header-links-wrapper > div.header-links > ul > li.usrelinks > ul > li:nth-child(2) > a"));
		
		
		WebElement menu = chromeDriver.findElement(By.xpath("//*[@id=\"en-page\"]/body/div[6]/header/div/div[3]/div[1]/ul/li[2]/a"));
		WebElement registerLink = chromeDriver.findElement(By.xpath("//*[@id=\"en-page\"]/body/div[6]/header/div/div[3]/div[1]/ul/li[2]/ul/li[2]/a"));
		
		Actions builder = new Actions(chromeDriver);
		builder.contextClick(menu).moveToElement(registerLink).click().build().perform();
	}
	@AfterTest
	public void closeDriver() {
		chromeDriver.quit();
	}
}
