package Pages;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ResuableComponents {

	WebDriver driver;
	
	//Method to take screenshot
	public void takeScreenhot(WebDriver driver1) throws IOException
	{
		TakesScreenshot screenshot = (TakesScreenshot)driver1;
		File source = screenshot.getScreenshotAs(OutputType.FILE);
		File target = new File("C://Eclipse-Selenium 13-07-2024//eclipse-java//Selenium_Concept//screenshots//TestCase.png");
		//FileHandler.copy(source, target);
		source.renameTo(target);
	}
	//Method to scroll using javascriptexecutor
	public void scrollToClick()
	{
		WebElement element = driver.findElement(By.xpath(""));
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].click();", element);
	}
	//Method to scroll using javascriptexecutor
	public void scrollToElement()
	{
		WebElement element = driver.findElement(By.xpath(""));
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].scrollIntoView();", element);
	}
	//Method to scroll
	public void scroll(WebDriver driver)
	{
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(0,500)", "");
	}
	//Method to scroll
	public void scroll2(WebDriver driver)
	{
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(0,1000)", "");
	}
	//Method to upload file using robot class
	public void uploadfile() throws AWTException
	{
		Robot robot = new Robot();
		StringSelection stringselection = new StringSelection("C://Users//Gaurav//Desktop//Book.xlsx");
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(stringselection, null);
		robot.keyPress(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_V);
		robot.delay(3000);
		robot.keyRelease(KeyEvent.VK_CONTROL);
		robot.keyRelease(KeyEvent.VK_C);
		robot.delay(3000);
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);
	}
	//Method to scroll
	public void scroll3(WebDriver driver)
	{
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		jse.executeScript("window.scrollBy(0,1500);", "");
	}
	//Method to scroll
	public void scroll4(WebDriver driver)
	{
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		jse.executeScript("window.scrollBy(0,2000);", "");
	}
	//Method to scroll
	public void scroll5(WebDriver driver)
	{
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		jse.executeScript("window.scrollBy(0,2500);", "");
	}
}
