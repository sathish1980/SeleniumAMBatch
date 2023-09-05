package BrowserDriver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;

import utils.PropertyFileHandle;

public class intilaizeBrowser {
	
	public static WebDriver driver;
	public static ExtentReports report;
	public static ExtentTest test;
	String reportPath = System.getProperty("user.dir")+"//Reports//";
	
	public void Launch()
	{
		String browserName = PropertyFileHandle.propreaddata().getProperty("browser");
		if(browserName.equalsIgnoreCase("Edge"))
		{
		driver = new EdgeDriver();
		}
		else if(browserName.equalsIgnoreCase("chrome"))
		{		
		 driver = new ChromeDriver();
		}
		driver.manage().window().maximize();
		StartExtentReport();
	}

	public void StartExtentReport()
	{
		report = new ExtentReports(reportPath+"extentReports.html",false);
		test = report.startTest("MakeMyTrip Automation");
	}
	
	public void CloseExtentReport()
	{
		report.flush();
	}
}
