package com.SeleniumWebDriver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ChromeDemo {

	public static void main(String[] args) {
		
		String ChromePath = System.getProperty("user.dir")+"\\resources\\chromedriver.exe";
		
		System.setProperty("webdriver.chrome.driver", ChromePath);
		//Initiate Chrome driver
		WebDriver driver = new ChromeDriver();
		//Navigate to google url
		driver.navigate().to("https://www.google.com/");
		driver.quit();

	}

}
