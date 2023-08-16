package SeleniumBasics;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Alertconcepts {
	
WebDriver driver;
	
public void alertimplementation() throws InterruptedException 
{
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://leafground.com/alert.xhtml");
		driver.findElement(By.id("j_idt88:j_idt91")).click();
		driver.switchTo().alert().accept();
		Thread.sleep(2000);
		// or
		//Alert alert = driver.switchTo().alert();
		//alert.accept();
		driver.findElement(By.id("j_idt88:j_idt93")).click();
		driver.switchTo().alert().dismiss();
		Thread.sleep(2000);
		driver.findElement(By.id("j_idt88:j_idt104")).click();
		Alert alert = driver.switchTo().alert();
		alert.sendKeys("Besant Technology");
		String alertText = alert.getText();
		System.out.println(alertText);
		alert.accept();
		Thread.sleep(2000);
		//Sweet alert
		driver.findElement(By.id("j_idt88:j_idt106")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//*[@id='j_idt88:j_idt107']//a")).click();
		Thread.sleep(2000);
		driver.findElement(By.id("j_idt88:j_idt106")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//*[@id='j_idt88:j_idt107']//button[@id='j_idt88:j_idt108']")).click();
}
	public static void main(String[] args) throws InterruptedException
	{
		// TODO Auto-generated method stub
		Alertconcepts a = new Alertconcepts();
		a.alertimplementation();
	}

}
