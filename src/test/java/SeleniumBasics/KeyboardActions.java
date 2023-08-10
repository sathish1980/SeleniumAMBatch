package SeleniumBasics;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class KeyboardActions {
	
	WebDriver browser;
	
	public void keyboardImplementation()
	{
			browser = new ChromeDriver();
			browser.get("https://www.facebook.com/");
			browser.manage().window().maximize();
			Actions mouse = new Actions(browser);
			mouse.moveToElement(browser.findElement(By.id("email"))).sendKeys("sathish").keyDown(Keys.TAB).keyUp(Keys.TAB).perform();
			//.sendKeys("sathish").keyDown(Keys.SHIFT).keyDown(Keys.TAB).keyUp(Keys.SHIFT).keyUp(Keys.TAB).perform();
	}
	
	public void keyboardwithRobot() throws AWTException
	{
			browser = new ChromeDriver();
			browser.get("https://www.facebook.com/");
			browser.manage().window().maximize();
			Actions mouse = new Actions(browser);
			mouse.moveToElement(browser.findElement(By.id("email"))).sendKeys("Besant").doubleClick().contextClick().perform();
			Robot r = new Robot();
			r.keyPress(KeyEvent.VK_DOWN);
			r.keyRelease(KeyEvent.VK_DOWN);
			r.keyPress(KeyEvent.VK_DOWN);
			r.keyRelease(KeyEvent.VK_DOWN);
			//r.keyPress(KeyEvent.VK_DOWN);
			//r.keyRelease(KeyEvent.VK_DOWN);
			r.keyPress(KeyEvent.VK_ENTER);
			r.keyRelease(KeyEvent.VK_ENTER);
			r.keyPress(KeyEvent.VK_TAB);
			r.keyRelease(KeyEvent.VK_TAB);
			r.keyPress(KeyEvent.VK_CONTROL);
			r.keyPress(KeyEvent.VK_V);
			r.keyRelease(KeyEvent.VK_CONTROL);
			r.keyRelease(KeyEvent.VK_V);
	}

	public static void main(String[] args) throws AWTException 
	{
		// TODO Auto-generated method stub
		KeyboardActions K = new KeyboardActions();
		K.keyboardwithRobot();
	}

}
