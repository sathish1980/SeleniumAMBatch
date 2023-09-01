package Pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Commons.ElementUtils;

public class SearchPage extends ElementUtils{

	@FindBy (xpath="//*[@for='fromCity']")
	WebElement fromCityElement;
	@FindBy (xpath="//*[@for='toCity']")
	WebElement toCityElement;
	@FindBy (xpath="//*[text()='Search']")
	WebElement searchButton;
	String fromCityElementBy = "//*[@for='fromCity']";
	@FindBy (xpath="//*[@id='fromCity']")
	WebElement getFromCityNameElement;
	@FindBy (xpath="//*[@id='toCity']")
	WebElement getToCityNameElement;
	
	WebDriver driver;
	
	public SearchPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	public void ClickFromLocation() throws InterruptedException
	{
		Thread.sleep(5000);
		//Explicitwaitforelementobeclickable(driver, driver.findElement(By.xpath("//*[@for='fromCity']")));
		Explicitwaitforelementobeclickable(driver, fromCityElement);
		
		//WebElement from = driver.findElement(By.xpath("//*[@for='fromCity']"));
		ButtonClick(fromCityElement);

	}
	
	public void ClickToLocation() throws InterruptedException
	{
		//Thread.sleep(5000);
		//Explicitwaitforelementobeclickable(driver, driver.findElement(By.xpath("//*[@for='toCity']")));
		Explicitwaitforelementobeclickable(driver, toCityElement);
		
		//driver.findElement(By.xpath("//*[@for='toCity']")).click();
		//toCity.click();
		ButtonClick(toCityElement);
	}
	
	public void SelectLocation(String expectedLocation)
	{
		String basePath= "//*[@id='react-autowhatever-1']//li";
		Explicitwaitforelementobeclickable(driver, driver.findElement(By.xpath("("+basePath+")[last()]")));
		List<WebElement> allElements = driver.findElements(By.xpath(basePath));
		for(int i=1;i<allElements.size();i++)
		{
			String actualLocation = driver.findElement(By.xpath("("+basePath+"["+i+"]//div[contains(@class,'pushRight')])[last()]")).getText();
			if (expectedLocation.equalsIgnoreCase(actualLocation))
			{
				driver.findElement(By.xpath("("+basePath+"["+i+"])[last()]")).click();
				break;
			}
				
		}
	}
	
	public void SelectADate(String dateToBeSelect)
	{
		String basePath ="((//*[@class='DayPicker-Month'])[last()-1]//*[@class='DayPicker-Week']//div[contains(@class,'DayPicker-Day')])";
		Explicitwaitforpresencefelement(driver, By.xpath(basePath));
		
		List<WebElement> AllDates = driver.findElements(By.xpath(basePath));
		for(int i=1;i<=AllDates.size();i++)
		{
			String dateIsDisabled = driver.findElement(By.xpath(basePath+"["+i+"]")).getAttribute("class");
			if(!dateIsDisabled.contains("disabled"))
			{
				List<WebElement> elementExist = driver.findElements(By.xpath(basePath+"["+i+"]//p"));
				if(elementExist.size()>0)
				{
					String actualDate = driver.findElement(By.xpath(basePath+"["+i+"]//p")).getText();
					if (actualDate.equalsIgnoreCase(dateToBeSelect))
					{
						driver.findElement(By.xpath(basePath+"["+i+"]")).click();
						break;
					}
				}
			}
			
		}
	}
	
	public void ClickOnSearchButton()
	{
		//WebElement search  =driver.findElement(By.xpath("//*[text()='Search']"));
		ButtonClick(searchButton);
	}
	
	public String GetErrorMessageForSameCity()
	{
		String basepath = "//*[@data-cy='sameCityError']";
		List<WebElement> elementExist = driver.findElements(By.xpath(basepath));
		if (elementExist.size() >0)
		{
		Explicitwaitforpresencefelement(driver, By.xpath(basepath));
		return driver.findElement(By.xpath(basepath)).getText();
		}
		return "No Error Exist";
	}
	
	public String GetFromLocationName()
	{
		//Explicitwaitforpresencefelement(driver, fromCityElementBy);
		Explicitwaitforpresencefelement(driver, By.xpath(fromCityElementBy));
		
		return GetAttribute(getFromCityNameElement, "value");
	}
	
	public String GetToLocationName()
	{
		Explicitwaitforpresencefelement(driver, By.xpath("//*[@id='toCity']"));
		//return .getAttribute("value");
		return GetAttribute(getToCityNameElement, "value");

	}
	
	public String GetSearchResultValue()
	{
		String finalResult = "Flights from "+GetFromLocationName()+" to "+GetToLocationName();
		return finalResult;
	}
}
