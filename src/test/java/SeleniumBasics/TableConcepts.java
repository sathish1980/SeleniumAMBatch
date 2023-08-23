package SeleniumBasics;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.opentelemetry.exporter.logging.SystemOutLogRecordExporter;

public class TableConcepts {
	
	public void tableimplementation(String expectedCountry) throws InterruptedException, IOException
	{

		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://leafground.com/table.xhtml");
		List<WebElement> Allpages = driver.findElements(By.xpath("//*[@class='ui-paginator-pages']//a"));
		for( int j=1;j<=Allpages.size();j++)
		{
			Thread.sleep(2000);
			
			WebElement eachPage = driver.findElement(By.xpath("//*[@class='ui-paginator-pages']//a["+j+"]"));
			
			JavascriptExecutor js= (JavascriptExecutor)driver;
			
			js.executeScript("arguments[0].scrollIntoView();", eachPage);

			eachPage.click();
			Thread.sleep(2000);
			takeScreenshot(driver,"FileName"+j);
		
		List<WebElement> allRows =driver.findElements(By.xpath("//table[@role='grid']//tbody//tr"));
		for (int i=1;i<=allRows.size();i++)
		{
			String actualCountry = driver.findElement(By.xpath("//table[@role='grid']//tbody//tr["+i+"]//td[2]//span[contains(@style,'vertical-align')]")).getText();
			
			if (expectedCountry.equalsIgnoreCase(actualCountry))
			{
				System.out.println(actualCountry);
				String name = driver.findElement(By.xpath("//table[@role='grid']//tbody//tr["+i+"]//td[1]")).getText();
				String representative = driver.findElement(By.xpath("//table[@role='grid']//tbody//tr["+i+"]//td[3]//span[contains(@style,'vertical-align')]")).getText();
				String Date = driver.findElement(By.xpath("//table[@role='grid']//tbody//tr["+i+"]//td[4]")).getText();
				String Status = driver.findElement(By.xpath("//table[@role='grid']//tbody//tr["+i+"]//td[5]//span[contains(@class,'customer-badge')]")).getText();
				
				System.out.println(name + " : "+representative+ " : "+Date+ " : "+ Status);
				//break;
			}
		}
		}
	}

	
	public void takeScreenshot(WebDriver driver,String fileName) throws IOException
	{
		TakesScreenshot ts =(TakesScreenshot)driver;
		File sourceFile =ts.getScreenshotAs(OutputType.FILE);
		File destinationFile = new File(System.getProperty("user.dir")+"\\Screenshot\\"+fileName+".png");
		FileUtils.copyFile(sourceFile, destinationFile);
		
	}
	public static void main(String[] args) throws InterruptedException, IOException {
		// TODO Auto-generated method stub
		TableConcepts T = new TableConcepts();
		T.tableimplementation("Argentina");
	}

}
