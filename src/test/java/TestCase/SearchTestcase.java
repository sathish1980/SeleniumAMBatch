package TestCase;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import BrowserDriver.intilaizeBrowser;
import Commons.ElementUtils;
import utils.PropertyFileHandle;

public class SearchTestcase extends intilaizeBrowser
{
	
	ElementUtils E = new ElementUtils();
	@BeforeSuite
	public void LauchTheBrowser()
	{
		Launch();
	}
	
	@BeforeTest
	public void LaunchTheURL()
	{
		String URL = PropertyFileHandle.propreaddata().getProperty("URL");
		driver.get(URL);
	}
	
	@BeforeClass
	public void ClearAdd() throws InterruptedException
	{
		ElementUtils E = new ElementUtils();
		driver.navigate().refresh();
		E.ClearPopups(driver);
	}
	
	@Test(priority=1)
	public void SearchWithValidValues() throws InterruptedException
	{
		/*Select the value from from location
		 * Select the value from tolocation
		 * Select the date 
		 * Click Search
		 * Validate the search result
		 */
		Assert.assertEquals(GetApplicationTitle(), "MakeMyTrip - #1 Travel Website 50% OFF on Hotels, Flights & Holiday");
		ClickFromLocation();
		SelectLocation("DEL");
		ClickToLocation();
		SelectLocation("MAA");
		String expectedResult = GetSearchResultValue();
		SelectADate("15");
		ClickOnSearchButton();
		waitForOkayGotIt();
		String actualResult = WaitAndGetSearchText();
		
		Assert.assertEquals(actualResult, expectedResult);	
	}
	
	@Test(priority=2)
	public void SearchWithSameCity() throws InterruptedException
	{
		/*Select the value from from location
		 * Select the same value in tolocation
		 * Validate the error message
		 */
		E.ClickOnBackButton(driver);
		E.ClearPopups(driver);
		ClickFromLocation();
		SelectLocation("DEL");
		ClickToLocation();
		SelectLocation("DEL");
		String actualResult = GetErrorMessageForSameCity();
		String expectedResult= "From & To airports cannot be the same";
		Assert.assertEquals(actualResult, expectedResult);	
	}
	
	@AfterSuite
	public void TearDown()
	{
		driver.quit();
	}
	
	public void ClickFromLocation() throws InterruptedException
	{
		//Thread.sleep(5000);
		E.Explicitwaitforelementobeclickable(driver, driver.findElement(By.xpath("//*[@for='fromCity']")));
		WebElement from = driver.findElement(By.xpath("//*[@for='fromCity']"));
		E.ButtonClick(from);

	}
	
	public void ClickToLocation() throws InterruptedException
	{
		//Thread.sleep(5000);
		E.Explicitwaitforelementobeclickable(driver, driver.findElement(By.xpath("//*[@for='toCity']")));
		
		driver.findElement(By.xpath("//*[@for='toCity']")).click();
		//toCity.click();
	}
	
	public void SelectLocation(String expectedLocation)
	{
		String basePath= "//*[@id='react-autowhatever-1']//li";
		E.Explicitwaitforelementobeclickable(driver, driver.findElement(By.xpath("("+basePath+")[last()]")));
		List<WebElement> allElements = driver.findElements(By.xpath(basePath));
		for(int i=1;i<allElements.size();i++)
		{
			String actualLocation = driver.findElement(By.xpath(basePath+"["+i+"]//div[contains(@class,'pushRight')]")).getText();
			if (expectedLocation.equalsIgnoreCase(actualLocation))
			{
				driver.findElement(By.xpath(basePath+"["+i+"]")).click();
				break;
			}
				
		}
	}
	
	public void SelectADate(String dateToBeSelect)
	{
		String basePath ="((//*[@class='DayPicker-Month'])[last()-1]//*[@class='DayPicker-Week']//div[contains(@class,'DayPicker-Day')])";
		E.Explicitwaitforpresencefelement(driver, By.xpath(basePath));
		
		List<WebElement> AllDates = driver.findElements(By.xpath(basePath));
		for(int i=1;i<=AllDates.size();i++)
		{
			String dateIsDisabled = driver.findElement(By.xpath("((//*[@class='DayPicker-Month'])[last()-1]//*[@class='DayPicker-Week']//div[contains(@class,'DayPicker-Day')])["+i+"]")).getAttribute("class");
			if(!dateIsDisabled.contains("disabled"))
			{
				List<WebElement> elementExist = driver.findElements(By.xpath("((//*[@class='DayPicker-Month'])[last()-1]//*[@class='DayPicker-Week']//div[contains(@class,'DayPicker-Day')])["+i+"]//p"));
				if(elementExist.size()>0)
				{
					String actualDate = driver.findElement(By.xpath("((//*[@class='DayPicker-Month'])[last()-1]//*[@class='DayPicker-Week']//div[contains(@class,'DayPicker-Day')])["+i+"]//p")).getText();
					if (actualDate.equalsIgnoreCase(dateToBeSelect))
					{
						driver.findElement(By.xpath("((//*[@class='DayPicker-Month'])[last()-1]//*[@class='DayPicker-Week']//div[contains(@class,'DayPicker-Day')])["+i+"]")).click();
						break;
					}
				}
			}
			
		}
	}
	
	public void ClickOnSearchButton()
	{
		WebElement search  =driver.findElement(By.xpath("//*[text()='Search']"));
		E.ButtonClick(search);
	}
	
	public String GetErrorMessageForSameCity()
	{
		List<WebElement> elementExist = driver.findElements(By.xpath("//*[@data-cy='sameCityError']"));
		if (elementExist.size() >0)
		{
		E.Explicitwaitforpresencefelement(driver, By.xpath("//*[@data-cy='sameCityError']"));
		return driver.findElement(By.xpath("//*[@data-cy='sameCityError']")).getText();
		}
		return "No Error Exist";
	}
	
	public String GetFromLocationName()
	{
		E.Explicitwaitforpresencefelement(driver, By.xpath("//*[@id='fromCity']"));
		return E.GetAttribute(driver.findElement(By.xpath("//*[@id='fromCity']")), "value");
	}
	
	public String GetToLocationName()
	{
		E.Explicitwaitforpresencefelement(driver, By.xpath("//*[@id='toCity']"));
		//return .getAttribute("value");
		return E.GetAttribute(driver.findElement(By.xpath("//*[@id='toCity']")), "value");

	}
	
	public String GetSearchResultValue()
	{
		String finalResult = "Flights from "+GetFromLocationName()+" to "+GetToLocationName();
		return finalResult;
	}
	
	public String WaitAndGetSearchText()
	{
		E.Explicitwaitforpresencefelement(driver, By.xpath("//*[contains(@class,'journey-title')]//span"));
		String actualResultText = driver.findElement(By.xpath("//*[contains(@class,'journey-title')]//span")).getText();
		return actualResultText;
	}

	public void waitForOkayGotIt() throws InterruptedException
	{
		E.Explicitwaitforpresencefelement(driver, By.xpath("(//div[@class='overlay']//span)[1]"));
		driver.findElement(By.xpath("(//div[@class='overlay']//span)[1]")).click();
	}
	
	public String GetApplicationTitle()
	{
		return driver.getTitle();
	}
	

}
