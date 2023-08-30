package BrowserDriver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

import utils.PropertyFileHandle;

public class intilaizeBrowser {
	
	public static WebDriver driver;
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
	}

}
