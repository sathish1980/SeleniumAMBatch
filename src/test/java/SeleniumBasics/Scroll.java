package SeleniumBasics;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Scroll {
	
	WebDriver driver;
	public void scrollimplementation() throws InterruptedException
	{
		//System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"\\driverfiles\\chromedriver_win32\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.navigate().to("https://leafground.com/drag.xhtml");
		JavascriptExecutor js= (JavascriptExecutor)driver;
		//vertical scroll down
		js.executeScript("window.scrollBy(0,750)", "");
		Thread.sleep(2000);
		//vertical scroll up
		js.executeScript("window.scrollBy(0,-250)", "");
		Thread.sleep(2000);
		//Horizontal scroll Right
		js.executeScript("window.scrollBy(250,0)", "");
		Thread.sleep(2000);
		//Horizontal scroll left
		js.executeScript("window.scrollBy(-250,0)", "");
		Thread.sleep(2000);
		
		//vertically scroll down to the end
		js.executeScript("window.scrollBy(0,document.body.scrollHeight)", "");
		Thread.sleep(2000);
		
		//vertically scroll up to the top
		js.executeScript("window.scrollBy(0,-document.body.scrollHeight)", "");
		Thread.sleep(2000);
		
		// Specific to the element
		WebElement startbutton=driver.findElement(By.xpath("//*[text()='Start']//parent::button"));
		js.executeScript("arguments[0].scrollIntoView();", startbutton);
	}

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		Scroll s = new Scroll();
		s.scrollimplementation();
	}

}
