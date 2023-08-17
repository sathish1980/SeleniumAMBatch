package SeleniumBasics;

import java.time.Duration;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WindowsHandling {
	
	WebDriver driver;
	
	public void WHimplementation() throws InterruptedException 
	{
			driver = new EdgeDriver();
			driver.manage().window().maximize();
			driver.get("https://leafground.com/window.xhtml");
			String currentWindows = driver.getWindowHandle();
			driver.findElement(By.id("j_idt88:new")).click();
			Set<String> allwindow =driver.getWindowHandles();
			for(String eachwindow : allwindow)
			{
				if(!eachwindow.equalsIgnoreCase(currentWindows))
				{
				driver.switchTo().window(eachwindow);
				List<WebElement> elementExist = driver.findElements(By.id("menuform:j_idt40"));
				WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(60));
				
				if(elementExist.size()>0)
				{
					driver.findElement(By.id("menuform:j_idt40")).click();
					wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='menuform:m_input']")));
					
					driver.findElement(By.xpath("//*[@id='menuform:m_input']")).click();
					String title = driver.getTitle();
					System.out.println(title);
					wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("j_idt88:name")));
					
					driver.findElement(By.id("j_idt88:name")).sendKeys("sathish");
					driver.quit();
				}
				}
				
				//driver.switchTo().window(currentWindows);
				
			}
			
	}

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		WindowsHandling W = new WindowsHandling();
		W.WHimplementation();
	}

}
