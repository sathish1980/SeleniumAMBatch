package SeleniumBasics;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class FirstClass {
	
	public void launch()
	{
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.facebook.com/");
		driver.manage().window().maximize();
		//WebElement username = driver.findElement(By.id("email"));
		//WebElement username = driver.findElement(By.cssSelector("input#email"));
		WebElement username = driver.findElement(By.cssSelector("input[data-testid='royal_email']"));
		
		username.sendKeys("sathish");
		username.clear();
		driver.findElement(By.id("email")).sendKeys("Kumar");
		driver.findElement(By.name("email")).sendKeys("besant");
		
		//driver.findElement(By.className("inputtext _55r1 _6luy")).sendKeys("hi");
		//driver.findElement(By.linkText("Forgotten password?")).click();
		driver.findElement(By.partialLinkText("pass")).click();
		//driver.close();
		//driver.quit();
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		FirstClass F = new FirstClass();
		F.launch();
	}

}
