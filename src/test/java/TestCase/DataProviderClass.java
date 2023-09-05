package TestCase;

import java.io.IOException;

import org.testng.annotations.DataProvider;

import utils.ExcelFileHandling;

public class DataProviderClass {
	
	@DataProvider(name ="ValidTestCase")
	public Object[][] searchWithValid() throws IOException
	{
		ExcelFileHandling EF = new ExcelFileHandling();
		return EF.ExcelReaddata("MakeMyTrip_8AM.xls", "SearchWithValid");
	}
	
	@DataProvider
	public Object[][] searchWithInValid() throws IOException
	{
		ExcelFileHandling EF = new ExcelFileHandling();
		return EF.ExcelReaddata("MakeMyTrip_8AM.xls", "SearchWithInvalid");
	}


}
