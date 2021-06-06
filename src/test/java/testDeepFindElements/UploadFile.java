package testDeepFindElements;

import static org.testng.Assert.assertEquals;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class UploadFile {
	String ChromePath = System.getProperty("user.dir") + "\\resources\\chromedriver.exe";
	WebDriver chromeDriver;
	String URL = "https://the-internet.herokuapp.com/upload";

	@BeforeTest
	public void openURL() {
		System.setProperty("webdriver.chrome.driver", ChromePath);
		chromeDriver = new ChromeDriver();
		chromeDriver.navigate().to(URL);

	}

	@Test(enabled = false)
	public void testUploadFileUsingFolder() {
		// Uploaded File Name in uploads folder
		String fileName = "Tasks.txt";
		// Get uploaded files path
		String filesPath = System.getProperty("user.dir") + "\\Uploads\\" + fileName;
		// Find Choose file button by ID
		WebElement choiceFileBtn = chromeDriver.findElement(By.id("file-upload"));
		// Send file to input choose file because its type is input
		choiceFileBtn.sendKeys(filesPath);
		// Find upload button by ID
		WebElement uploadBtn = chromeDriver.findElement(By.id("file-submit"));
		// Click on upload file
		uploadBtn.click();
		WebElement h = chromeDriver.findElement(By.xpath("//*[@id=\"content\"]/div/h3"));
		assertEquals(h.getText(), "File Uploaded!");

	}

	@Test
	public void testUploadFileUsingRobotClass() throws AWTException {
		String fileName = "Tasks.txt";
		String filesPath = System.getProperty("user.dir") + "\\Uploads\\" + fileName;
		
		
		WebElement choiceFileBtn = chromeDriver.findElement(By.id("file-upload"));
		choiceFileBtn.click();
		
		
		//Object from Robot Class from Java
		Robot robot = new Robot();
		//Ctrl + C copy image path into file name of external window 
		StringSelection selection = new StringSelection(filesPath);
		Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
		clipboard.setContents(selection, null);
		
		//Press on enter
		robot.keyPress(KeyEvent.VK_ENTER);
		//Remove my hand from key 
		robot.keyRelease(KeyEvent.VK_ENTER);
		robot.delay(2000);
		
		//Click on Ctrl + V 
		robot.keyPress(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_V);
		robot.keyRelease(KeyEvent.VK_V);
		robot.keyRelease(KeyEvent.VK_CONTROL);
		robot.delay(2000);
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);
		
		WebElement uploadBtn = chromeDriver.findElement(By.id("file-submit"));
		// Click on upload file
		uploadBtn.click();
		
		//WebElement h = chromeDriver.findElement(By.xpath("//*[@id=\"content\"]/div/h3"));
		//assertEquals(h.getText(), "File Uploaded!");

	}

	@AfterTest
	public void closeDriver() {
		chromeDriver.quit();
	}
}
