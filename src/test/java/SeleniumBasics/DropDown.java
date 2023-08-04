package SeleniumBasics;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.WebDriver;

public class DropDown {
	
	WebDriver driver;
	
	public void mutiselect() throws InterruptedException
	{
		//System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"\\driverfiles\\chromedriver_win32\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://chercher.tech/practice/practice-dropdowns-selenium-webdriver");
		Select products= new Select(driver.findElement(By.xpath("//*[@class='col-lg-3' and @id='second']")));
		
		if (products.isMultiple())
		{
			Thread.sleep(2000);
			products.selectByValue("burger");
			Thread.sleep(2000);
			products.selectByIndex(0);
			Thread.sleep(2000);
			products.selectByVisibleText("Donut");
			Thread.sleep(2000);
			products.deselectByVisibleText("Donut");
			Thread.sleep(2000);
			products.deselectAll();
		}
	}
	
	public void dropdown()
	{
			EdgeOptions options = new EdgeOptions();
			//options.addArguments("start-maximized");
			//options.addArguments("--disable-Notifications");

			WebDriver browser = new EdgeDriver(options);
			browser.get("https://www.facebook.com/");
			browser.manage().window().maximize();
			
			// implicity wait
			browser.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
			browser.findElement(By.xpath("//*[@data-testid='open-registration-form-button']")).click();
		
			Select dayDropdown = new Select(browser.findElement(By.xpath("//*[@id='day']")));
			//dayDropdown.selectByIndex(15);
			//dayDropdown.selectByValue("10");
			dayDropdown.selectByVisibleText("19");
			
			Select monthDropdown = new Select(browser.findElement(By.xpath("//*[@id='month']")));
			
			monthDropdown.selectByValue("10");
	}

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		DropDown d = new DropDown();
		d.mutiselect();
	}

}
