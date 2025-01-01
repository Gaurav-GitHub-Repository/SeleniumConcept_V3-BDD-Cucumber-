package Pages;

import java.time.Duration;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Dashboard4 {


	ResuableComponents component = new ResuableComponents();

	WebDriver driver;

	//Constructor to assign driver
	public Dashboard4(WebDriver driver)
	{
		this.driver=driver;
		//PageFactory.initElements(driver, this);
	}

	//WebElement for search tab
	private @FindBy(css="input.wikipedia-search-input")
	WebElement search_tab;
	
	//WebElement for search button
	private @FindBy(css="input.wikipedia-search-button")
	WebElement search_button;	
	
	//WebElement for search result
	private @FindBy(xpath="//div[@class='wikipedia-search-results']/div[1]/a")
	WebElement search_result;		
	
	//WebElement for dynamic button
	private @FindBy(xpath="//div[@class='widget HTML' and @id='HTML5']/div/button")
	WebElement dynamic_button;		
	
	//WebElement for dynamic start button
	private @FindBy(xpath="//button[text()='START']")
	WebElement start_button;		
	
	//WebElement for dynamic stop button
	private @FindBy(xpath="//button[text()='STOP']")
	WebElement stop_button;		
	
	//WebElement for simple alert
	private @FindBy(xpath="//button[text()='Simple Alert']")
	WebElement simple_alert;		
		
	//WebElement for confirmation alert
	private @FindBy(xpath="//button[text()='Confirmation Alert']")
	WebElement confirmation_alert;		
	
	//WebElement for prompt alert
	private @FindBy(xpath="//button[text()='Prompt Alert']")
	WebElement prompt_alert;		
	
	//WebElement for new tab
	private @FindBy(xpath="//button[text()-'New Tab']")
	WebElement newtab_button;		
	
	//WebElement for poptab_button 
	private @FindBy(xpath="//button[text()='Popup Windows']")
	WebElement popuptab_button;		
		
	//WebElement for mouse hover button
	private @FindBy(xpath="//button[text()='Point Me']")
	WebElement mousehover_button;		
		
	//WebElement for double click button
	private @FindBy(xpath="//button[text()='Copy Text']")
	WebElement doubleclick;		
	
	//WebElement for input field2 text box
	private @FindBy(xpath="//div[@class='sidebar section']/div[7]/div/input[2]")
	WebElement inputtextbox2;		
	
	//WebElement for drag and drop text
	private @FindBy(xpath="//div[@class='sidebar section']/div[8]/h2")
	WebElement dragAnddrop;		
	
	//WebElement for source element
	private @FindBy(xpath="//div[@id='draggable']/p")
	WebElement sourcelement;		
	
	//WebElement for target element			
	private @FindBy(xpath="//div[@id='droppable']")
	WebElement targetelement;		
	
	//WebElement for slider
	private @FindBy(xpath="//div[@id='slider-range']/span[1]")
	WebElement slider;		
	
	//WebElement for SVG red circle
	private @FindBy(xpath="//div[@class='svg-container']//*[name()='svg'][1]")
	WebElement SVG_RedCircle;		
		
	//WebElement for SVG green rectangle
	private @FindBy(xpath="//div[@class='svg-container']//*[name()='svg'][3]")
	WebElement SVG_GreenRectangle;		

	//WebElement SVG_BlueTriangle;
	private @FindBy(xpath="//div[@class='svg-container']//*[name()='svg'][3]")
	WebElement SVG_BlueTriangle;			
	
	//WebElement for scrolling dropdown textbox
	private @FindBy(xpath="//input[@id='comboBox' and @type='text']")
	WebElement scrolltextbox;			

	//WebElement for link
	private @FindBy(xpath="//div[@id='laptops']/a[1]")
	WebElement link;			
	
	
	//Method to enter text in search tab
	public void setenterSearch(String value)
	{
		By search_tab = By.cssSelector("input.wikipedia-search-input");
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(search_tab));
		driver.findElement(search_tab).sendKeys(value);
	}
	//Method to click on search button
	public void setSearchButton()
	{
		By search_button = By.cssSelector("input.wikipedia-search-button");
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(search_button));
		driver.findElement(search_button).click();
		//	driver.findElement(search_button).sendKeys(Keys.TAB);
		By search_result = By.xpath("//div[@class='wikipedia-search-results']/div[1]/a");
		WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait1.until(ExpectedConditions.presenceOfAllElementsLocatedBy(search_result));
		driver.findElement(search_result).sendKeys(Keys.ENTER);
	}
	//Method to click on dynamic start button
	public void setDynamicButton1()
	{
		By start_button = By.xpath("//button[text()='START']");
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(start_button));
		driver.findElement(start_button).click();
		WebElement dynamic_button1 = driver.findElement(By.xpath("//div[@class='widget HTML' and @id='HTML5']/div/button"));
		if(dynamic_button1.getText().equals("STOP"))
		{
			System.out.println("Dynamic button1 is verified");
		}
		else
		{
			System.out.println("Dynamic button1 is not verified");
		}
	}
	//Method to click on dynamic start button
	public void setDynamicButton2()
	{
		By stop_button = By.xpath("//button[text()='STOP']");
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(stop_button));
		driver.findElement(stop_button).click();
		WebElement dynamic_button1 = driver.findElement(By.xpath("//div[@class='widget HTML' and @id='HTML5']/div/button"));
		if(dynamic_button1.getText().equals("START"))
		{
			System.out.println("Dynamic button2 is verified");
		}
		else
		{
			System.out.println("Dynamic button2 is not verified");
		}
	} 
	//Method to click on simple alert
	public void setSimpleAlert()
	{
		simple_alert.click();
		Alert alert = driver.switchTo().alert();
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(20));
		wait.until(ExpectedConditions.alertIsPresent());
		String alerttext = alert.getText();
		if(alerttext.contains("I am an alert box!"))
		{
			alert.accept();
			System.out.println("Alert is verified");
		}
		else
		{
			System.out.println("Alert is not verified");
		}
	}
	//Method to click on confirmation alert
	public void setConfirmationAlert()
	{
		WebElement element = driver.findElement(By.xpath("//div[@id='sidebar-right-1']/div[3]/h2"));
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].scrollIntoView();", element);

		confirmation_alert.click();
		Alert alert = driver.switchTo().alert();
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(20));
		wait.until(ExpectedConditions.alertIsPresent());
		String alerttext = alert.getText();
		if(alerttext.contains("Press a button!"))
		{
			alert.accept();
			System.out.println("Confirmation alert is verified");
		}
		else
		{
			alert.dismiss();
			System.out.println("Confirmation alert is not verified");
		}
	}
	//Method to click on prompt alert
	public void setPromptAlert() throws InterruptedException
	{
		WebElement element = driver.findElement(By.xpath("//div[@id='sidebar-right-1']/div[3]/h2"));
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].scrollIntoView();", element);
		
		prompt_alert.click();
		Alert alert = driver.switchTo().alert();
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(20));
		wait.until(ExpectedConditions.alertIsPresent());
		alert.sendKeys("Prompt Alert");
		alert.accept();
		if(driver.findElement(By.xpath("//div[@id='HTML9']/div/p")).getText().contains("Hello Prompt ALert! How are you today?"))
		{
			System.out.println("Prompt alert is verified");
		}
		else
		{
			System.out.println("Prompt alert is not verified");
		}
	}
	//Method to click on new tab
	public void setWindow1()
	{
		WebElement element = driver.findElement(By.xpath("//button[text()='New Tab']"));
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].scrollIntoView();", element);
		
		js.executeScript("arguments[0].click();", element);
		Set<String> id = driver.getWindowHandles();
		for(String handleid:id)
		{
			driver.switchTo().window(handleid);
			String child_title =driver.switchTo().window(handleid).getTitle();
			if(driver.getTitle().equalsIgnoreCase(child_title))
			{
				System.out.println("New window tab is verified");
			}
			else
			{
				System.out.println("New window tab is not verified");
			} 
		} 
	}
	public void setWindow2()
	{
		WebElement element = driver.findElement(By.xpath("//button[text()='New Tab']"));
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].scrollIntoView();", element);

		String parenthandle = driver.getWindowHandle();
		System.out.println("parenthandle :" + parenthandle);
		System.out.println(driver.getTitle());
		
		popuptab_button.click();
		Set<String> handles = driver.getWindowHandles();
		Iterator it = handles.iterator();
		it.hasNext();
		String childwindow = (String) it.next();
		System.out.println(childwindow);
		String childwindow1 = (String) it.next();
		System.out.println(childwindow1);
		if(parenthandle!=childwindow1)
		{
			driver.switchTo().window(childwindow1);
			if(driver.getTitle().equals("Fast and reliable end-to-end testing for modern web apps | Playwright"))
			{
				System.out.println("User is on second window");
			}
			else
			{
				System.out.println("User is not on second window");
			}
		}

	}
/*	//Method to click on multiple pop up window
	public void setWindow2()
	{
		WebElement element = driver.findElement(By.xpath("//button[text()='New Tab']"));
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].scrollIntoView();", element);
		
		String parenthandle = driver.getWindowHandle();
		System.out.println(parenthandle);
		driver.findElement(popuptab_button).click();
		Set<String> handles = driver.getWindowHandles();
		for(int i=0;i<=handles.size();i++)
		{
			List<String> windowid = new ArrayList();
			String childwindow = windowid.get(i);
			System.out.println(childwindow);
			driver.switchTo().window(childwindow);	
		}
	} */
	//Method to mouse hover the button
	public void setMouseHover()
	{
		WebElement element = driver.findElement(By.xpath("//div[@class='sidebar section']/div[6]/h2"));
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].scrollIntoView();", element);
		
		WebElement button = driver.findElement(By.xpath("//button[text()='Point Me']"));
		Actions action = new Actions(driver);
		action.moveToElement(button).build().perform();
		action.clickAndHold(button).build().perform();
	}
	//Method to double click on button
	public void setDoubleClick()
	{
		WebElement element = driver.findElement(By.xpath("//div[@class='sidebar section']/div[7]/h2"));
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].scrollIntoView();", element);
		
		WebElement button = driver.findElement(By.xpath("//button[text()='Copy Text']"));
		Actions action = new Actions(driver);
		action.clickAndHold(button).build().perform();
		action.doubleClick(button).build().perform();
		
		By inputtextbox2 = By.xpath("//div[@class='sidebar section']/div[7]/div/input[2]");
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(20));
		wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(inputtextbox2));
		String textvalue = driver.findElement(inputtextbox2).getAttribute("value");
		if(textvalue.contains("Hello World!"))
		{
			System.out.println("Double click is verified");
		}	
		else
		{
			System.out.println("Double click is not verified");
		}
	}
	//Method to drag and drop
	public void setdragAnddrop()
	{
		WebElement element = driver.findElement(By.xpath("//div[@class='sidebar section']/div[8]/h2"));
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].scrollIntoView();", element);
		
		WebElement source = driver.findElement(By.xpath("//div[@id='draggable']/p"));
		WebElement target = driver.findElement(By.xpath("//div[@id='droppable']"));		
		Actions action = new Actions(driver);
		action.clickAndHold(source).build().perform();
		action.moveToElement(target).build().perform();
		action.dragAndDrop(source, target).build().perform();	
	}
	//Method for slider
	public void setSlider()
	{
		WebElement element = driver.findElement(By.xpath("//div[@class='sidebar section']/div[9]/h2"));
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].scrollIntoView();", element);
		
		WebElement slider = driver.findElement(By.xpath("//div[@id='slider-range']/span[1]"));
		System.out.println("Location of slider is" + slider.getLocation());
		System.out.println("Size of slider is" + slider.getSize());
		Actions action = new Actions(driver);
		action.clickAndHold(slider).build().perform();
		action.moveToElement(slider).dragAndDropBy(slider, 150, 0).build().perform();
	}
	//Method to verify svg colour element is displayed
	public void setVerifySVGElement()
	{
		WebElement element = driver.findElement(By.xpath("//div[@class='sidebar section']/div[10]/h2"));
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].scrollIntoView();", element);
		
		int elements = driver.findElements(By.xpath("//div[@class='svg-container']")).size();
	
		for(int i=1;i<=elements;i++)
		{
			if(driver.findElement(By.xpath("//div[@class='svg-container']//*[name()='svg']["+i+"]")).isDisplayed()==true)
			{
				System.out.println("SVG red circle element is displayed" + " SVG green rectangle element is displayed" + " SVG blue triangle element is displayed");
			}
			else
			{
				System.out.println("SVG element is not displayed");
			}
		}
	}
	//Method for scrolling dropdown
	public void setScrollDropdown() throws InterruptedException
	{
		WebElement element = driver.findElement(By.xpath("//div[@class='sidebar section']/div[11]/h2"));
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].scrollIntoView();", element);
		
		List<WebElement> value = driver.findElements(By.xpath("//div[@id='dropdown']/div"));

		WebElement scrolltextbox1 = driver.findElement(By.xpath("//input[@id='comboBox' and @type='text']"));
		By scrolltext = By.xpath("//input[@id='comboBox' and @type='text']");
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(scrolltext));
		Actions action = new Actions(driver);
		action.clickAndHold(scrolltextbox1).click().build().perform();
		action.sendKeys(Keys.TAB).build().perform();
		action.sendKeys(Keys.ARROW_DOWN).build().perform();
		for(int i=1;i<=100;i++)
		{
			action.sendKeys(Keys.ARROW_DOWN).build().perform();
			if(i==20)
			{
				break;
			}
		}
	}

	//Method to click on links
	public void setLink() throws InterruptedException
	{
		WebElement element = driver.findElement(By.xpath("//div[@class='sidebar section']/div[12]/h2"));
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].scrollIntoView();", element);
		
		WebElement link = driver.findElement(By.xpath("//div[@id='laptops']/a[3]"));
		for(int i=1;i<=3;i++)
		{
			driver.findElement(By.xpath("//div[@id='laptops']/a["+i+"]")).click();
			Thread.sleep(5000);
			System.out.println(driver.getTitle());
			driver.navigate().back();
		}
	}
}
