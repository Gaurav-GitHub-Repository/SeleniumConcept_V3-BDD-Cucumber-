package Pages;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class Dashboard {

	
	WebDriver driver;

	ResuableComponents component = new ResuableComponents();

	//Constructor to assign driver
	public Dashboard(WebDriver driver)
	{
		this.driver=driver;
		//PageFactory.initElements(driver, this);
	}

	//WebElement for selenium, cypress & playwright
	private @FindBy(xpath="//span[text()='For Selenium, Cypress & Playwright']")
	WebElement Header;
	
	//WebElement for GUI element text
	private @FindBy(xpath="//div[@class='columns-inner']/div[1]/div/div/div/div/div/div/div/div/h3")
	WebElement GUIElement;
	
	//WebElement for registration form name
	private @FindBy(xpath="//input[@id='name']/parent::div/input")
	WebElement Name;
	
	//WebElement for registration form  email
	private @FindBy(xpath="//input[@id='email']/parent::div/input[2]")
	WebElement Email_id;
	
	//WebElement for registration form phone 
	private @FindBy(xpath="//input[@id='phone']/parent::div/input[3]")
	WebElement Phone;
	
	//WebElement for registration form address
	private @FindBy(xpath="//textarea[@id='textarea']/parent::div/textarea")
	WebElement  Address;
	
	//WebElemnt for male radio button1
	private @FindBy(xpath="//input[@id='male' and @name='gender']")
	WebElement Gender1;
	
	//WebElemnt for male radio button2
	private @FindBy(xpath="//input[@id='female' and @name='gender']")
	WebElement Gender2 ;
	
	//WebElement for checkbox
	private @FindBy(xpath="//div[@class='columns-inner']/div/div/div/div/div/div/div/div/div/div[2]/div[4]/div[1]/label")
	WebElement NumberOfCheckbox;
	
	//WebElement for country
	private @FindBy(xpath="//select[@id='country']")
	WebElement Country;	
	
	//WebElement for Colors
	private @FindBy(xpath="//select[@id='colors']")
	WebElement Colors;	

	//WebElement for link
	private @FindBy(xpath="//a[text()='Posts (Atom)']")
	WebElement link;	
	
	
	//Method to verify header text
	public void setHeader()
	{
		String HeaderText = "For Selenium, Cypress &amp; Playwright']";
		if(Header.getText().contains(HeaderText))
		{
			System.out.println("Header Text is verified");
			Assert.assertTrue(true);
		}
		else
		{
			System.out.println("Header text is not verified");
			Assert.assertTrue(false);
		}
	}
	//Method to verify GUI element text
	public void setGUIElement()
	{
		String element = driver.findElement(By.xpath("//div[@class='columns-inner']/div[1]/div/div/div/div/div/div/div/div/h3")).getText();
		String expected_value = "GUI Elements"; 

		if(element.equalsIgnoreCase(expected_value))
		{
			System.out.println("GUI Element text is verified");
			Assert.assertTrue(true);
		}
		else
		{
			System.out.println("GUI Element text is not verified");
			Assert.assertTrue(false);
		}
	}
	//Method to enter name
	public void setName(String name)
	{
		By Name = By.xpath("//input[@id='name']/parent::div/input");
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(Name));
		driver.findElement(Name).clear();
		driver.findElement(Name).sendKeys(name);
		System.out.println("Name is entered");
	}
	//Method to enter email
	public void setEmail(String email)
	{
		By Email_id = By.xpath("//input[@id='email']/parent::div/input[2]");
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(Email_id));
		driver.findElement(Email_id).clear();
		driver.findElement(Email_id).sendKeys(email);
		System.out.println("Email id is entered");
	}
	//Method to enter phone
	public void setPhone(String phone)
	{
		By Phone = By.xpath("//input[@id='phone']/parent::div/input[3]");
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(Phone));
		driver.findElement(Phone).clear();
		driver.findElement(Phone).sendKeys(phone);
		System.out.println("Phone number is entered");
	}
	//Method to enter address
	public void setAddress(String address)
	{
		By Address = By.xpath("//textarea[@id='textarea']/parent::div/textarea");
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(Address));
		driver.findElement(Address).clear();
		driver.findElement(Address).sendKeys(address);
	}
	public void setGender1()
	{
		boolean button1 = Gender1.isDisplayed();
		if(button1==true)
		{
			Gender1.click();
			System.out.println("Radio button1 is selected");
		}
		else
		{
			System.out.println("Radio button1 is not selected");
		}
	}
	public void setGender2()
	{
		boolean button1 = Gender2.isDisplayed();
		if(button1==true)
		{
			Gender2.click();
			System.out.println("Radio button2 is selected");
		}
		else
		{
			System.out.println("Radio button2 is not selected");
		}
	}
	//Method to scroll
	public void scroll()
	{
		component.scroll(driver);
	}
	//Method to select checkbox
	public void setNumberOfCheckbox()
	{
		List<WebElement> checkbox = driver.findElements(By.xpath("//div[@class='columns-inner']/div/div/div/div/div/div/div/div/div/div[2]/div[4]"));
		for(int i=1; i<=7; i++)
		{
			//driver.findElement(By.xpath("//div[@class='columns-inner']/div/div/div/div/div/div/div/div/div/div[2]/div[4]/div["+i+"]/input")).click();
			driver.findElement(By.xpath("//div[@class='columns-inner']/div/div/div/div/div/div/div/div/div/div[2]/div[4]/div["+i+"]/label")).click();
			if(i==7)
			{
				System.out.println("Checkbox is selected");
				break;
			}
		}
	}
	//Method to select country dropdown
	public void setCountry()
	{
		//WebElement for country
		WebElement dropdown = driver.findElement(By.xpath("//select[@id='country']"));
		Select select = new Select(dropdown);
		List<WebElement> var = select.getOptions();
		for(WebElement value:var)
		{
			if(value.getText().contains("India"))
			{
				select.selectByVisibleText("India");
				System.out.println("Dropdown is selected and verified");
				break;
			}
		}
	}
	//Method to select form colour
	public void setColors()
	{
		WebElement color = driver.findElement(By.xpath("//select[@id='colors']")); 
		Select select = new Select(color);
		List<WebElement> var = select.getOptions();
		for(WebElement value:var)
		{
			System.out.println(value.getText());
			break;
		}
	}
	public void scroll2()
	{
		component.scroll2(driver);
	}
	//Method to click on link
	public void setlink()
	{
		try
		{
			By link = By.xpath("//a[text()='Posts (Atom)']");
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
			wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(link));
			driver.findElement(link).click();
		}
		catch(TimeoutException e)
		{
			System.out.println("Timeout Exception Occured");
		}
	}
}
