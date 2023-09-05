package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Commons.ElementUtils;

public class SearcResultPage extends ElementUtils {

	@FindBy (xpath = "//*[contains(@class,'journey-title')]//span")
	WebElement searchTextElement;
	@FindBy (xpath="(//div[@class='overlay']//span)[1]")
	WebElement okGotItElement;
	
	private String searchTextElementBy = "//*[contains(@class,'journey-title')]//span";
	private String okGotItElementBy ="(//div[@class='overlay']//span)[1]";
	
	WebDriver driver;
	
	public SearcResultPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	public String WaitAndGetSearchText()
	{
		//Explicitwaitforpresencefelement(driver, By.xpath("//*[contains(@class,'journey-title')]//span"));
		Explicitwaitforpresencefelement(driver, By.xpath(searchTextElementBy));
		
		String actualResultText = searchTextElement.getText();
		return actualResultText;
	}

	public void waitForOkayGotIt() throws InterruptedException
	{
		Explicitwaitforpresencefelement(driver, By.xpath("(//div[@class='overlay']//span)[1]"));
		//Explicitwaitforpresencefelement(driver, okGotItElementBy);
		
		//driver.findElement(By.xpath("(//div[@class='overlay']//span)[1]")).click();
		ButtonClick(okGotItElement);
	}
}
