package stepDefination;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import Pages.Dashboard2;
import Pages.Dashboard3;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class testcase15 {

	
	WebDriver driver;

	final String URL = "https://testautomationpractice.blogspot.com/";

	@Before(order=1)
	@Given("^ Launch browser and navigate to URL $")
	public void Launch_browser_and_navigate_to_URL()
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
	@When("^ Enter value in form and click on submit button $")
	public void  Enter_value_in_form_and_click_on_submit_button() throws InterruptedException 
	{
		//Method to call Dashboard1
    	Dashboard3 dashboard3 = new Dashboard3(driver);
    	dashboard3.setForm1("Form1");
    	dashboard3.setForm2("Form2");
    	dashboard3.setForm3("Form3");
	}
	@Then("^ Form is verified  $")
	public void Form_is_verified() 
	{
		System.out.println("Form is verified");		
	}
	/*	@After(order=1)
	public void logout()
	{
		driver.close();
	} */
}
