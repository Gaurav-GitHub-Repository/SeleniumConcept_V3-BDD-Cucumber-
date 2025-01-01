package Pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Dashboard3 {

	ResuableComponents component = new ResuableComponents();
	
	WebDriver driver;
	
	//Constructor to assign driver
	public Dashboard3(WebDriver driver)
	{
		this.driver=driver;
		//PageFactory.initElements(driver, this);
	}
	
	//WebElement for form1
	private @FindBy(xpath="//div[@id='HTML6']/div/div/div/input[@name='input1']")
	WebElement Form1;
	
	//WebElement for form2
	private @FindBy(xpath="//div[@id='HTML6']/div/div/div[2]/input[@id='input2']")
	WebElement Form2;
	
	//WebElement for form3
	private @FindBy(xpath="//div[@id='HTML6']/div/div/div[3]/input[@id='input3']")
	WebElement Form3;
	
	//WebElement for button1
	private @FindBy(xpath="//div[@id='HTML6']/div/div/div[1]/button")
	WebElement Button1;
		
	//WebElement for button2
	private @FindBy(xpath="//div[@id='HTML6']/div/div/div[2]/button")
	WebElement Button2;
	
	//WebElement for button3
	private @FindBy(xpath="//div[@id='HTML6']/div/div/div[3]/button")
	WebElement Button3;
	
	//WebElement to toggle input box2
	private @FindBy(xpath="//button[text()='Toggle Input Box 2']")
	WebElement button_inputbox2;
	
	//WebElement for input box2
	private @FindBy(xpath="//div[@id='container']/input[2]")
	WebElement inputbox2;

	//WebElement for input box1
	private @FindBy(xpath="//div[@id='container']/input[1]")
	WebElement inputbox1;
	
	//WebElement for checkbox1
	private @FindBy(xpath="//input[@id='checkbox1' and @type='checkbox']")
	WebElement checkbox1;
	
	//WebElement for toggle checkbox2
	private @FindBy(xpath="//button[text()='Toggle Checkbox 2']")
	WebElement button_checkbox2;
	
	//WebElement for checkbox2
	private @FindBy(xpath="//input[@type='checkbox' and @id='checkbox2']")
	WebElement checkbox2;
	
	//WebElement for load ajax button
	private @FindBy(xpath="//button[text()='Load AJAX Content']")
	WebElement button_load;
	
	//WebElement for ajax content
	private @FindBy(xpath="//div[@id='ajaxContent']/p")
	WebElement ajaxcontent;
	
	//WebElement for footer link
	private @FindBy(linkText="Home")
	WebElement link1;
	
	//WebElement for hidden element link
	private @FindBy(linkText="Hidden Elements & AJAX")
	WebElement link2;
	
	//WebElement for download file link3
	private @FindBy(linkText="Download Files")
	WebElement link3;
	
	//WebElement for textbox
	private @FindBy(xpath="//textarea[@id='inputText']/parent::div/textarea")
	WebElement textbox;
	
	//WebElement for text file button
	private @FindBy(xpath="//button[text()='Generate and Download Text File']")
	WebElement textfile_button;
	
	//WebElement to generate textfile link
	private @FindBy(linkText="Download Text File")
	WebElement textfile_link;
	
	//WebElement to generate pdf file button
	private @FindBy(xpath="//button[text()='Generate and Download PDF File']")
	WebElement PDFfile_button;
	
	//WebElement for download pdf file
	private @FindBy(xpath="//button[text()='Download PDF File']")
	WebElement DownloadPDF_button;
	
	//WebElement for download pdf file link
	private @FindBy(xpath="//a[@id='pdfDownloadLink']")
	WebElement downloadpdf_link;
	
	
	//Method to click on link2
	public void setlink2()
	{
		WebElement FooterLink = driver.findElement(By.xpath("//div[@class='foot section']/div[2]/h2"));
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].scrollIntoView();", FooterLink);
		
		By link2 = By.xpath("Hidden Elements & AJAX");
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(link2));
		driver.findElement(link2).click();
	}	
	//Method to enter input box1
	public void setlinkinputbox(String value)
	{
		By inputbox1 = By.xpath("//div[@id='container']/input[1]");
		WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait1.until(ExpectedConditions.presenceOfAllElementsLocatedBy(inputbox1));
		driver.findElement(inputbox1).clear();
		driver.findElement(inputbox1).sendKeys(value);
		System.out.println("inputbox1 is verified");
	}
	//Method to enter input box2
	public void setlinkinputbox2(String value)
	{
		button_inputbox2.click();
		By inputbox2 = By.xpath("//div[@id='container']/input[2]");
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(inputbox2));
		driver.findElement(inputbox2).clear();
		driver.findElement(inputbox2).sendKeys(value);
		System.out.println("inputbox2 is verified");
	}
	//Method to click on checkbox1
	public void setCheckbox1()
	{
		By checkbox1 = By.xpath("//div[@id='container']/input[2]");
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(checkbox1));
		driver.findElement(checkbox1).click();
		boolean Checkbox1 = driver.findElement(checkbox1).isDisplayed();
		if(Checkbox1==true)
		{
			System.out.println("Checkbox1 is verified");
		}
		else
		{
			System.out.println("Checkbox1 is not verified");
		}
	}
	//Method to click on checkbox2
	public void setCheckbox2()
	{
		button_checkbox2.click();
		By checkbox1 = By.xpath("//div[@id='container']/input[2]");
		By checkbox2 = By.xpath("//input[@type='checkbox' and @id='checkbox2']");
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(checkbox2));
		driver.findElement(checkbox2).click();
		boolean Checkbox2 = driver.findElement(checkbox2).isDisplayed();
		if(Checkbox2==true)
		{
			System.out.println("Checkbox2 is verified");
		}
		else
		{
			System.out.println("Checkbox2 is not verified");
		}
	}
	//Method to click on load ajax button
	public void setAjaxContent()
	{
		button_load.click();
		By AjaxContent = By.xpath("//div[@id='ajaxContent']/p");
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(AjaxContent));
		if(driver.findElement(AjaxContent).getText().contains("This is some dynamic content loaded through AJAX."))
		{
			System.out.println("Ajax content is verified");
		}
		else
		{
			System.out.println("Ajax content is not verified");
		}
	}
	//Method to click on download file footer link
	public void setlink3()
	{
		link3.click();
	}
	//Method to enter textbox
	public void setAjaxdownloadfile(String value)
	{
		//Enter textbox
		By textbox = By.xpath("//textarea[@id='inputText']/parent::div/textarea");
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(textbox));
		driver.findElement(textbox).clear();
		driver.findElement(textbox).sendKeys(value);
		//Click on text file button
		textfile_button.click();
		By textfile_link = By.linkText("Download Text File");
		WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait1.until(ExpectedConditions.presenceOfAllElementsLocatedBy(textfile_link));
		driver.findElement(textfile_link).click();
		System.out.println("Text file is downloaded");
	}
	//Method to click on generate and download PDF file
	public void setAjaxdownloadfile1()
	{
		//Generate PDF file
		PDFfile_button.click();
		By downloadpdf_link = By.linkText("//a[@id='pdfDownloadLink']");
		WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait1.until(ExpectedConditions.presenceOfAllElementsLocatedBy(downloadpdf_link));
		driver.findElement(downloadpdf_link).click();
		System.out.println("PDF file is downloaded");
	}
	//Method to click on download pdf file with browser
	public void setAjaxdownloadfile2()
	{
		//Generate PDF file with browser
		DownloadPDF_button.click();
		System.out.println("PDF file with browser");
	}
	//Method to click on link1
	public void setlink1() throws InterruptedException
	{
		WebElement FooterLink = driver.findElement(By.xpath("//div[@class='foot section']/div[2]/h2"));
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].scrollIntoView();", FooterLink);
		
		try
		{
			By link1 = By.linkText("Home");
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
			wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(link1));
			driver.findElement(link1).click();
			if(driver.getTitle().equalsIgnoreCase("Automation Testing Practice"))
			{
				System.out.println("Page is verified");
			}
			else
			{
				System.out.println("Page is not verified");
			}
		}
		catch(TimeoutException e)
		{
			System.out.println("TimeoutException Occured");
		}
	}
	//Method to enter form1 
	public void setForm1(String value)
	{
		WebElement Form = driver.findElement(By.xpath("//div[@class='foot section' and @id='footer-2-1']/div[1]/h2"));
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].scrollIntoView();", Form);
		
		WebElement Section1 = driver.findElement(By.xpath("//div[@class='foot section' and @id='footer-2-1']/div[1]/div/div/div[1]/h4"));		
		if(Section1.getText().equals("Section 1"))
		{
			By Form1 = By.xpath("//div[@id='HTML6']/div/div/div/input[@name='input1']");
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
			wait.until(ExpectedConditions.visibilityOfElementLocated(Form1));
			driver.findElement(Form1).clear();
			driver.findElement(Form1).sendKeys(value);
			Button1.click();
			System.out.println("Form1 is entered");
		}
		else
		{
			System.out.println("Form1 is not entered");
		}		
	}
	//Method to enter form2
	public void setForm2(String value)
	{
		WebElement Section2 = driver.findElement(By.xpath("//div[@class='foot section' and @id='footer-2-1']/div[1]/div/div/div[2]/h4"));
		if(Section2.getText().equals("Section 2"))
		{
			By Form2 = By.xpath("//div[@id='HTML6']/div/div/div[2]/input[@id='input2']");
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
			wait.until(ExpectedConditions.visibilityOfElementLocated(Form2));
			driver.findElement(Form2).clear();
			driver.findElement(Form2).sendKeys(value);
			Button2.click();
			System.out.println("Form2 is entered");
		}
		else
		{
			System.out.println("Form2 is not entered");
		}		
	}
	//Method to enter form3
	public void setForm3(String value)
	{
		WebElement Section3 = driver.findElement(By.xpath("//div[@class='foot section' and @id='footer-2-1']/div[1]/div/div/div[3]/h4"));
		if(Section3.getText().equals("Section 3"))
		{
			By Form3 = By.xpath("//div[@id='HTML6']/div/div/div[3]/input[@id='input3']");
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
			wait.until(ExpectedConditions.visibilityOfElementLocated(Form3));
			driver.findElement(Form3).clear();
			driver.findElement(Form3).sendKeys(value);
			Button3.click();
			System.out.println("Form3 is entered");
		}
		else
		{
			System.out.println("Form3 is not entered");
		}		
	}
}
