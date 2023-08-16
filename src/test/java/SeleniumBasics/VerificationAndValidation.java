package SeleniumBasics;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class VerificationAndValidation {
	
	WebDriver driver;
	public void vvImplementation() throws InterruptedException 
	{
			driver = new ChromeDriver();
			driver.manage().window().maximize();
			driver.get("https://leafground.com/checkbox.xhtml");
			
			//validation commands (boolean value)
			//1 .isSelected() -- checkbox and radiobutton
			//2. isDisplayed()
			//3. isEnabled()
			
			
			
			Boolean buttonStatus = driver.findElement(By.id("j_idt87:j_idt89")).isSelected();
			System.out.println(buttonStatus);
			driver.findElement(By.id("j_idt87:j_idt89")).click();
			Boolean buttonStatus1 = driver.findElement(By.id("j_idt87:j_idt89")).isSelected();
			System.out.println(buttonStatus1);
			
			Boolean buttonEnabledStatus1 = driver.findElement(By.id("j_idt87:j_idt102")).isEnabled();
			System.out.println(buttonEnabledStatus1);
			
			Boolean buttonDisplayedStatus1 = driver.findElement(By.id("j_idt87:j_idt102")).isDisplayed();
			System.out.println(buttonDisplayedStatus1);
			
			//Verification Commands
			//1.getTitle(); 
			//2.getCurrentUrl();
			// 3. getText();
			//4.getAttribute();
			//5.getPageSource();
			//6.getWindowhandle();
			//7.getWindowhandles();
			
			String Title = driver.getTitle();
			System.out.println(Title);
			String url = driver.getCurrentUrl();
			System.out.println(url);
			String text = driver.findElement(By.xpath("//*[@id='j_idt87:j_idt89']//span[@class='ui-chkbox-label']")).getText();
			System.out.println(text);
			String classAttribute = driver.findElement(By.xpath("//*[@id='j_idt87:j_idt89']")).getAttribute("class");
			System.out.println(classAttribute);
			String dom = driver.getPageSource();
			System.out.println(dom);
			String windowName = driver.getWindowHandle();
			System.out.println(windowName);
			Set<String> windowNames = driver.getWindowHandles();
			System.out.println(windowNames);
			
	}

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		VerificationAndValidation V = new VerificationAndValidation();
		V.vvImplementation();
	}

}
