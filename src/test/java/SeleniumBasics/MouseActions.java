package SeleniumBasics;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.interactions.Actions;

public class MouseActions {
	
	WebDriver browser;
	
	public void mouseImplementation()
	{
			EdgeOptions options = new EdgeOptions();
			browser = new EdgeDriver(options);
			browser.get("https://www.ebay.com/");
			browser.manage().window().maximize();
			Actions mouse = new Actions(browser);
			mouse.moveToElement(browser.findElement(By.xpath("//*[@class='hl-cat-nav__js-tab']//*[text()='Electronics']"))).perform();
			mouse.moveToElement(browser.findElement(By.xpath("//a[text()='Computers and tablets']"))).click().perform();
	}
	
	public void mouseImplementation2()
	{
			browser = new ChromeDriver();
			browser.get("https://www.facebook.com/");
			browser.manage().window().maximize();
			Actions mouse = new Actions(browser);
			mouse.moveToElement(browser.findElement(By.id("email"))).sendKeys("sathish").doubleClick().contextClick().perform();
		}
	
	public void mouseDragAndDrop()
	{
			browser = new ChromeDriver();
			browser.get("https://leafground.com/drag.xhtml");
			browser.manage().window().maximize();
			Actions mouse = new Actions(browser);
			mouse.moveToElement(browser.findElement(By.id("form:drag"))).dragAndDrop(browser.findElement(By.id("form:drag")), browser.findElement(By.id("form:drop"))).perform();
		}

	public void mouseDragAndDropby()
	{
			browser = new ChromeDriver();
			browser.get("https://leafground.com/drag.xhtml");
			browser.manage().window().maximize();
			JavascriptExecutor js= (JavascriptExecutor)browser;
			
			//vertical scroll to page end
			js.executeScript("window.scrollBy(0,document.body.scrollHeight)");
			
			Actions mouse = new Actions(browser);
			mouse.moveToElement(browser.findElement(By.xpath("(//*[contains(@class,'ui-slider-handle')])[1]"))).dragAndDropBy(browser.findElement(By.xpath("(//*[contains(@class,'ui-slider-handle')])[1]")),-15, 0).perform();
			mouse.moveToElement(browser.findElement(By.xpath("(//*[contains(@class,'ui-slider-handle')])[2]"))).dragAndDropBy(browser.findElement(By.xpath("(//*[contains(@class,'ui-slider-handle')])[2]")),50, 0).perform();

		}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MouseActions M = new MouseActions();
		M.mouseDragAndDropby();
	}

}
