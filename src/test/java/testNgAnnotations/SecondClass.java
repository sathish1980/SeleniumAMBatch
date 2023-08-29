package testNgAnnotations;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class SecondClass {
	
	@Test(priority=-1,description="Login",enabled=true,groups={"Sanity"})
	public void Testcase5() throws InterruptedException
	{
		System.out.println("Test case 5");
		//Thread.sleep(8000);
	}
	
	@Test(priority=-2,description="forgotPassword",timeOut=60,groups="Sanity")
	public void Testcase6()
	{
		System.out.println("Test case 6");
	}
	
	@BeforeSuite(alwaysRun=true)
	public void BeforeSuite() {
		System.out.println("BeforeSuite");
	}
	
	@AfterTest(alwaysRun=true)
	public void AfterTest() {
		System.out.println("@AfterTest");
	}
	
	@BeforeClass(alwaysRun=true)
	public void BeforeClass() {
		System.out.println("@BeforeClass in second class");
	}
}
