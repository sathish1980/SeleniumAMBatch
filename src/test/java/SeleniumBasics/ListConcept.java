package SeleniumBasics;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class ListConcept 
{

	WebDriver browser;
	public void listconceptImplementation(String expectedCountryName)
	{
			EdgeOptions options = new EdgeOptions();
			WebDriver browser = new EdgeDriver(options);
			browser.get("https://leafground.com/select.xhtml");
			browser.manage().window().maximize();
			browser.findElement(By.xpath("//*[@id='j_idt87:country']//div[contains(@class,'ui-selectonemenu-trigger')]")).click();
			List<WebElement> countries = browser.findElements(By.xpath("//*[@id='j_idt87:country_items']//li"));
			int size = countries.size();
			
			for(int i=1;i<=size;i++)
			{
				WebDriverWait wait = new WebDriverWait(browser,Duration.ofSeconds(60));
				wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//*[@id='j_idt87:country_items']//li[last()]")));
				String actualPath = "//*[@id='j_idt87:country_items']//li[";
				String actualCountryName = browser.findElement(By.xpath(actualPath+i+"]")).getText();
				if(actualCountryName.equalsIgnoreCase(expectedCountryName))
				{
					browser.findElement(By.xpath(actualPath+i+"]")).click();
					break;
				}
			}
			
	}
	
	public void listconceptImplementationanotherWay(String expectedCountryName)
	{
			EdgeOptions options = new EdgeOptions();
			browser = new EdgeDriver(options);
			browser.get("https://leafground.com/select.xhtml");
			browser.manage().window().maximize();
			browser.findElement(By.xpath("//*[@id='j_idt87:country']//div[contains(@class,'ui-selectonemenu-trigger')]")).click();
			List<WebElement> countries = browser.findElements(By.xpath("//*[@id='j_idt87:country_items']//li"));
			
			for(WebElement eachCountries : countries)
			{		
				String actualCountryName = eachCountries.getText();
				if(actualCountryName.equalsIgnoreCase(expectedCountryName))
				{
					eachCountries.click();
					break;
				}
			}
			
	}
	
	public void citySelection(String expectedCityName)
	{
		By dropdown =By.xpath("//*[@id='j_idt87:city']//div[contains(@class,'ui-selectonemenu-trigger')]");
		WebDriverWait wait = new WebDriverWait(browser,Duration.ofSeconds(60));
		wait.until(ExpectedConditions.elementToBeClickable(dropdown));
		browser.findElement(dropdown).click();
			
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='j_idt87:city_items']//li[last()]")));
			
			List<WebElement> cities = browser.findElements(By.xpath("//*[@id='j_idt87:city_items']//li"));
			
			for(WebElement eachCities : cities)
			{		
				String actualCityName = eachCities.getText();
				System.out.println(actualCityName);
				if(actualCityName.equalsIgnoreCase(expectedCityName))
				{
					System.out.println("inside of if");
					eachCities.click();
					break;
				}
			}
			
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ListConcept L = new ListConcept();
		L.listconceptImplementationanotherWay("USA");
		L.citySelection("San Francisco");
	}

}
