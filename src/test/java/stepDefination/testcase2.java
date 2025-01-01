package stepDefination;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.DesiredCapabilities;

import Pages.Dashboard;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class testcase2 {

	
	WebDriver driver;

	final String URL = "https://testautomationpractice.blogspot.com/";
	
	@Before(order=1)
	@Given("^ launch browser and navigate to Url $")
	public void launch_browser_and_navigate_to_Url()
	{
		int browser=1;
		switch(browser)
		{
		case 1:
			//DesiredCapabilities caps = new DesiredCapabilities();
			//caps.setPlatform("Windows");
			//caps.setBrowserName("Google Chrome");
			//caps.setVersion("130.0.6723.117");
			ChromeOptions option = new ChromeOptions();
			//option.addArguments("--headless");
			option.addArguments("--verbose");
			System.setProperty("webdriver.chrome.driver", "C:\\Eclipse-Selenium 13-07-2024\\eclipse-java\\Selenium\\drivers\\chromedriver.exe");
			driver = new ChromeDriver(option);
			driver.manage().window().maximize();
			driver.get(URL);
			driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);	
		case 2:	
			//DesiredCapabilities caps1 = new DesiredCapabilities();
			//caps1.setPlatform("Windows");
			//caps1.setBrowserName("MozillaFirefox");
			//caps1.setVersion("130.0.6723.117");
			FirefoxOptions option1 = new FirefoxOptions();
			//option1.addArguments("--headless");
			option1.addArguments("--verbose");
			System.setProperty("webdriver.gecko.driver", "C:\\Eclipse-Selenium 13-07-2024\\eclipse-java\\Selenium\\drivers\\geckodriver.exe");
			driver = new FirefoxDriver(option1);
			driver.manage().window().maximize();
			driver.get(URL);
			driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
		case 3:
			//DesiredCapabilities caps2 = new DesiredCapabilities();
			//caps2.setPlatform("Windows");
			//caps2.setBrowserName("MicrosoftEdge");
			//caps2.setVersion("131.0.2903.51");
			System.setProperty("webdriver.edge.driver", "C:\\Eclipse-Selenium 13-07-2024\\eclipse-java\\Selenium\\drivers\\msedgedriver.exe");
			driver = new EdgeDriver();
			driver.manage().window().maximize();
			driver.get(URL);
			driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
		default:
			System.out.println("Browser is not launched");
		}
	}
	@Given("^ User is on dashboard page $^")
	public void user_is_on_dashboard_page() 
	{
		String expected_value = "Automation Testing Practice";
		if(driver.getTitle().equalsIgnoreCase(expected_value))
		{
			System.out.println("User is on the dashboard page");
		}	
		else
		{
			System.out.println("User is not on the dashboard page");
		}
	}
	@When("Verify name, email, phone and address")
	public void verify_name_email_phone_and_address(String name, String email, String phone, String address) 
	{
		//Method to call Dashboard
		Dashboard dashbaord = new Dashboard(driver);
		dashbaord.setName(name);
		dashbaord.setEmail(email);
		dashbaord.setPhone(phone);
		dashbaord.setAddress(address);
	}
	@Then(": Regsitration form is verified")
	public void regsitration_form_is_verified() 
	{
		System.out.println("Registration form is verified");		
	}
	/*	@After(order=1)
	public void logout()
	{
		driver.close();
	} */
}