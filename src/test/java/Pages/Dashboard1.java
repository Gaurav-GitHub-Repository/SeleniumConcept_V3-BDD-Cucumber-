package Pages;

import java.awt.AWTException;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Dashboard1 {

	
	ResuableComponents component = new ResuableComponents();
	
	WebDriver driver;
	
	//Constructor to assign driver
	public Dashboard1(WebDriver driver)
	{
		this.driver=driver;
		//PageFactory.initElements(driver, this);
	}
	
	//WebElement for Date Picker1
	@FindBy(xpath="//input[@id='datepicker' and @class='hasDatepicker']")
	WebElement Date_Picker1;
	
	//WebElement for Date Picker 2
	@FindBy(xpath="//input[@id='txtDate' and @name='SelectedDate']")
	WebElement Date_Picker2;

	//WebElement for choose file button 1
	//private By Choose_File1 = By.xpath("//*[@id='singleFileInput']");  
	@FindBy(xpath="//form[@id='singleFileForm']/input")
	WebElement Choose_File1;
		
	//WebElement to upload single file
	@FindBy(xpath="//button[text()='Upload Single File']")
	WebElement Single_FileButton;
	
	
	//Method to select date
	public void setDate_Picker1() throws InterruptedException
	{
		int Month = 3;
		int TotalNumberOfMonths = 12;
		By Date_Picker1 = By.xpath("//input[@id='datepicker' and @class='hasDatepicker']");
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(Date_Picker1));
		driver.findElement(Date_Picker1).click();
		for(int i=1; i<=TotalNumberOfMonths; i++)
		{
			Thread.sleep(5000);
			driver.findElement(By.xpath("//div[@class='ui-datepicker-header ui-widget-header ui-helper-clearfix ui-corner-all']/a[2]")).click();
			if(i==Month)
			{
				if(driver.findElement(By.xpath("//span[text()='March']")).getText().equalsIgnoreCase("March"))
				{
					driver.findElement(By.xpath("//table[@class='ui-datepicker-calendar']/tbody/tr/td[7]/a")).click();
					WebElement month = driver.findElement(By.xpath("//span[text()='March']"));
					WebElement date = driver.findElement(By.xpath("//table[@class='ui-datepicker-calendar']/tbody/tr[4]/td[1]"));
					System.out.println("Month : " + month.getText() + " Date :" + date.getText());
					break;
				}
				else
				{
					System.out.println("DatePicker is not selected");
				}
			}
		}
	}
	//Method to select date2
	public void setDate_Picker2()
	{
		String Month = "Mar";
		String Year = "2025";
		int date = 1;
		By Date_Picker2 = By.xpath("//input[@id='txtDate' and @name='SelectedDate']");
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(Date_Picker2));
		driver.findElement(Date_Picker2).click();
		WebElement month = driver.findElement(By.cssSelector("select.ui-datepicker-month"));
		Select select = new Select(month);
		//select.selectByVisibleText("Mar");
		List<WebElement> dropdownmonth = select.getOptions();
		for(WebElement selectmonth:dropdownmonth)
		{
			if(selectmonth.getText().equals(Month))
			{
				select.selectByVisibleText("Mar");
				System.out.println("Month is verified and selected : " + Month);
				break;
			}
		} 
		
		Select select2 = new Select(driver.findElement(By.cssSelector("select.ui-datepicker-year")));
		//select2.selectByVisibleText("2025");
		List<WebElement> year = select2.getOptions();
		for(WebElement selectyear:year)
		{
			if(selectyear.getText().equalsIgnoreCase(Year))
			{
				select2.selectByVisibleText("2025");
				System.out.println("Year is verified and selected : " + Year);
				driver.findElement(By.xpath("//table[@class='ui-datepicker-calendar']/tbody/tr/td[7]/a")).click();
				System.out.println("Date is selected : " +  date);
				break;
			}
		} 
	}
	//Method to click upload file
	public void setChoose_File1() throws InterruptedException
	{
		component.scroll3(driver);
		Single_FileButton.click();
		Actions action = new Actions(driver);
		WebElement element = driver.findElement(By.xpath("//form[@id='singleFileForm']/input")); 
		action.clickAndHold(element).build().perform();
		action.doubleClick(element).build().perform();
		try 
		{
			Thread.sleep(3000);
			component.uploadfile();
		}
		catch (AWTException e) 
		{
			System.out.println("File is not uploaded. Exception occured");
		}
	}
	//Method to scroll
	public void scroll2()
	{
		component.scroll2(driver);
	}
}
