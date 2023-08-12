package SeleniumBasics;

import java.awt.AWTException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Frames {
	
	WebDriver browser;
	public void FrameImplementation() throws AWTException, InterruptedException
	{
			/*browser = new ChromeDriver();
			browser.get("https://leafground.com/frame.xhtml");
			browser.manage().window().maximize();*/
			List<WebElement> totalFrames =  browser.findElements(By.tagName("iframe"));
			
			for(int i=0;i<totalFrames.size();i++)
			{
				browser.switchTo().frame(i);
				List<WebElement> elementExist =  browser.findElements(By.xpath("//*[contains(@style,'#ff7295') and text()='Click Me']"));
				if(elementExist.size() > 0)
				{
					browser.findElement(By.xpath("//*[contains(@style,'#ff7295') and text()='Click Me']")).click();
					browser.switchTo().defaultContent();
					break;
				}
				
			}
			
				}	

	public void multiFrameImplementation() throws AWTException, InterruptedException
	{
			browser = new ChromeDriver();
			browser.get("https://leafground.com/frame.xhtml");
			browser.manage().window().maximize();
			List<WebElement> totalFrames =  browser.findElements(By.tagName("iframe"));
			
			for(int i=0;i<totalFrames.size();i++)
			{
				browser.switchTo().frame(i);
				List<WebElement> totalinnerFrames =  browser.findElements(By.tagName("iframe"));
				if(totalinnerFrames.size() > 0)
				{
					browser.switchTo().frame("frame2");
					List<WebElement> elementExist =  browser.findElements(By.xpath("//*[contains(@style,'#4b7ecf') and text()='Click Me']"));
					if(elementExist.size() > 0)
					{
						browser.findElement(By.xpath("//*[contains(@style,'#4b7ecf') and text()='Click Me']")).click();
						browser.switchTo().defaultContent();
						break;
					}
				}
				browser.switchTo().defaultContent();
				
				
			}
			
				}	

	
	public static void main(String[] args) throws AWTException, InterruptedException {
		// TODO Auto-generated method stub
		Frames F = new Frames();
		F.multiFrameImplementation();
		F.FrameImplementation();
	}

}
