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
	
	@Test(priority=1,dataProvider="searchWithValid")
	public void SearchWithValidValues(String fromLoc, String toLoc, String date) throws InterruptedException
	{
		/*Select the value from from location
		 * Select the value from tolocation
		 * Select the date 
		 * Click Search
		 * Validate the search result
		 */
		Assert.assertEquals(GetApplicationTitle(), "MakeMyTrip - #1 Travel Website 50% OFF on Hotels, Flights & Holiday");
		SearchPage s = new SearchPage(driver);
		s.ClickFromLocation();
		s.SelectLocation(fromLoc);
		s.ClickToLocation();
		s.SelectLocation(toLoc);
		String expectedResult = s.GetSearchResultValue();
		s.SelectADate(date);
		s.ClickOnSearchButton();
		SearcResultPage sp = new SearcResultPage(driver);
		sp.waitForOkayGotIt();
		String actualResult = sp.WaitAndGetSearchText();
		Assert.assertEquals(actualResult, expectedResult);	
		E.ClickOnBackButton(driver);
		E.ClearPopups(driver);
	}
	
	@Test(priority=2,dataProvider="searchWithInValid")
	public void SearchWithSameCity(String fromLoc, String toLoc) throws InterruptedException
	{
		/*Select the value from from location
		 * Select the same value in tolocation
		 * Validate the error message
		 */
		SearchPage s = new SearchPage(driver);
		s.ClickFromLocation();
		s.SelectLocation(fromLoc);
		s.ClickToLocation();
		s.SelectLocation(toLoc);
		String actualResult = s.GetErrorMessageForSameCity();
		String expectedResult= "From & To airports cannot be the same";
		Assert.assertEquals(actualResult, expectedResult);	
	}
	
	@AfterSuite
	public void TearDown()
	{
		driver.quit();
	}
	
	public String GetApplicationTitle()
	{
		return driver.getTitle();
	}
	
	@DataProvider
	public Object[][] searchWithValid() throws IOException
	{
		ExcelFileHandling EF = new ExcelFileHandling();
		return EF.ExcelReaddata("MakeMyTrip_8AM.xls", "SearchWithValid");
	}
	
	@DataProvider
	public Object[][] searchWithInValid() throws IOException
	{
		ExcelFileHandling EF = new ExcelFileHandling();
		return EF.ExcelReaddata("MakeMyTrip_8AM.xls", "SearchWithInvalid");
	}

}
