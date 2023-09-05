package TestCase;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import BrowserDriver.intilaizeBrowser;
import Commons.ElementUtils;
import Pages.SearcResultPage;
import Pages.SearchPage;
import utils.ExcelFileHandling;
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
	
	@Test(priority=1,dataProvider="ValidTestCase",dataProviderClass=DataProviderClass.class)
	public void SearchWithValidValues(String fromLoc, String toLoc, String date) throws InterruptedException
	{
		/*Select the value from from location
		 * Select the value from tolocation
		 * Select the date 
		 * Click Search
		 * Validate the search result
		 */
		SearchPage s = new SearchPage(driver);
		
		try
		{
		test.log(LogStatus.INFO, "Browser is Launched sucessfully");
		Assert.assertEquals(GetApplicationTitle(), "MakeMyTrip - #1 Travel Website 50% OFF on Hotels, Flights & Holiday");
		s.ClickFromLocation();
		s.SelectLocation(fromLoc);
		test.log(LogStatus.INFO, "From location is sucessfully clicked and the selected value is : "+fromLoc);
		
		s.ClickToLocation();
		s.SelectLocation(toLoc);
		test.log(LogStatus.INFO, "To location is sucessfully clicked and the selected value is : "+toLoc);
		String expectedResult = s.GetSearchResultValue();
		s.SelectADate(date);
		test.log(LogStatus.INFO, "Date selection is sucessfully clicked and the selected value is : "+date);
		s.ClickOnSearchButton();
		test.log(LogStatus.INFO, "Search button is clicked sucessfully");
		SearcResultPage sp = new SearcResultPage(driver);
		sp.waitForOkayGotIt();
		test.log(LogStatus.INFO, "POP up is clicked sucessfully");
		String screenShot = s.takescreenshot(driver);
		String actualResult = sp.WaitAndGetSearchText();
		Assert.assertEquals(actualResult, expectedResult);
		test.log(LogStatus.INFO, "Actual and expected text is matched" +actualResult);
		E.ClickOnBackButton(driver);
		test.log(LogStatus.INFO, "Back button clicked sucessfuly");
		E.ClearPopups(driver);
		// test.log(LogStatus.INFO, "All Steps are executed sucessfully");
		test.log(LogStatus.PASS, test.addScreenCapture(screenShot));
		
		}
		catch(Exception E)
		{
			String screenShot = s.takescreenshot(driver);
			test.log(LogStatus.ERROR, E);
			test.log(LogStatus.FAIL, test.addScreenCapture(screenShot));
			
		}
	}
	
	@Test(priority=2,dataProvider="searchWithInValid",dataProviderClass=DataProviderClass.class)
	public void SearchWithSameCity(String fromLoc, String toLoc) throws InterruptedException
	{
		/*Select the value from from location
		 * Select the same value in tolocation
		 * Validate the error message
		 */
		SearchPage s = new SearchPage(driver);
		s.ClickFromLocation();
		s.SelectLocation(fromLoc);
		test.log(LogStatus.INFO, "From location is sucessfully clicked and the selected value is : "+fromLoc);
		
		s.ClickToLocation();
		s.SelectLocation(toLoc);
		test.log(LogStatus.INFO, "To location is sucessfully clicked and the selected value is : "+toLoc);
		
		String screenShot = s.takescreenshot(driver);
		String actualResult = s.GetErrorMessageForSameCity();
		String expectedResult= "From & To airports cannot be the same";
		Assert.assertEquals(actualResult, expectedResult);	
		test.log(LogStatus.INFO, "Actual and expected text is matched" +actualResult);
		test.log(LogStatus.INFO, "All Steps are executed sucessfully");
		test.log(LogStatus.PASS, test.addScreenCapture(screenShot));
	}
	
	@AfterSuite
	public void TearDown()
	{
		CloseExtentReport();
		driver.quit();
	}
	
	public String GetApplicationTitle()
	{
		return driver.getTitle();
	}
	
	
}
