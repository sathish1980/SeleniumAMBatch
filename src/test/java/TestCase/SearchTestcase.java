package TestCase;

import org.openqa.selenium.WebDriver;
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
	
	@Test
	public void SearchWithValidValues()
	{
		/*Select the value from from location
		 * Select the value from tolocation
		 * Select the date 
		 * Click Search
		 * Validate the search result
		 */
	}
	
	@AfterSuite
	public void TearDown()
	{
		//driver.quit();
	}

}
