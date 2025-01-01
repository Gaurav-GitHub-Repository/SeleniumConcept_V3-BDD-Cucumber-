package stepDefination;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import Pages.Dashboard3;
import Pages.Dashboard4;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class testcase19 {

	
	WebDriver driver;

	final String URL = "https://testautomationpractice.blogspot.com/";

	@Before(order=1)
	@Given("^ Launch Browser and navigate to Url $")
	public void Launch_Browser_and_navigate_to_Url()
	{
		int browser=1;
		switch(browser)
		{
		case 1:
			ChromeOptions option = new ChromeOptions();
			//option.addArguments("--headless");
			System.setProperty("webdriver.chrome.driver", "C:\\Eclipse-Selenium 13-07-2024\\eclipse-java\\Selenium\\drivers\\chromedriver.exe");
			driver = new ChromeDriver(option);
			driver.manage().window().maximize();
			driver.get(URL);
			driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);	
		case 2:	
			FirefoxOptions option1 = new FirefoxOptions();
			//option1.addArguments("--headless");
			System.setProperty("webdriver.gecko.driver", "C:\\Eclipse-Selenium 13-07-2024\\eclipse-java\\Selenium\\drivers\\geckodriver.exe");
			driver = new FirefoxDriver(option1);
			driver.manage().window().maximize();
			driver.get(URL);
			driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
		case 3:
			System.setProperty("webdriver.edge.driver", "C:\\Eclipse-Selenium 13-07-2024\\eclipse-java\\Selenium\\drivers\\msedgedriver.exe");
			driver = new EdgeDriver();
			driver.manage().window().maximize();
			driver.get(URL);
			driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
		default:
			System.out.println("Browser is not launched");
		}
	}
	@When("^ User enter text in search $")
	public void  User_enter_text_in_search() throws InterruptedException 
	{
		//Method to call Dashboard4
		Dashboard4 dashboard4 = new Dashboard4(driver);
		dashboard4.setenterSearch("Selenium");
	}
	@When("^ Click on search button $")
	public void Click_on_search_button() throws InterruptedException 
	{
		//Method to call Dashboard4
		Dashboard4 dashboard4 = new Dashboard4(driver);
		dashboard4.setSearchButton();
	}
	@Then("^ Search is verified  $")
	public void Search_is_verified() 
	{
		System.out.println("Search is verified");		
	}
	/*	@After(order=1)
	public void logout()
	{
		driver.close();
	} */
}