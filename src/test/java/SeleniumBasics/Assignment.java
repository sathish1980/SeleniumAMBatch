package SeleniumBasics;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class Assignment {
	
	WebDriver driver;
	
	public void launch(String browserValue)
	{
		if(browserValue.equalsIgnoreCase("chrome"))
		{
			driver = new ChromeDriver();
			driver.get("https://www.facebook.com/");
			driver.manage().window().maximize();
		}
		else if(browserValue.trim().equalsIgnoreCase("edge"))
		{
			driver = new EdgeDriver();
			driver.get("https://www.facebook.com/");
			driver.manage().window().maximize();
		}
		driver.findElement(By.linkText("Forgotten password?")).click();
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Assignment A = new Assignment();
		A.launch("edge ");
	}

}
