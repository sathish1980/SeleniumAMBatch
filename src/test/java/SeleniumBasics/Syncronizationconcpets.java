package SeleniumBasics;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Syncronizationconcpets {
	
	public void sync() throws InterruptedException
	{
		EdgeOptions options = new EdgeOptions();
		options.addArguments("start-maximized");
		options.addArguments("--disable-Notifications");

		WebDriver browser = new EdgeDriver(options);
		browser.get("https://www.facebook.com/");
		browser.manage().window().maximize();
		browser.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
		browser.findElement(By.xpath("//*[@data-testid='open-registration-form-button']")).click();
		Thread.sleep(3000);
		WebDriverWait wait = new WebDriverWait(browser,Duration.ofSeconds(60));
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.name("firstname")));
		
		browser.findElement(By.name("firstname")).sendKeys("sathish");
		
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.name("lastname")));
		
		browser.findElement(By.name("lastname")).sendKeys("sathish");

	}

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		Syncronizationconcpets s = new Syncronizationconcpets();
		s.sync();
	}

}
