package SeleniumBasics;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class FirstClass {
	
	public void launch()
	{
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.facebook.com/");
		driver.manage().window().maximize();
		
		//driver.close();
		//driver.quit();
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
