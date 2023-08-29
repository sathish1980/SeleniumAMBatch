package testNgAnnotations;
import org.testng.annotations.*;

public class FristClass 
{
	
	
	@AfterSuite(alwaysRun=true)
	public void AfterSuite() {
		System.out.println("@AfterSuite");
	}
	
	@BeforeTest(alwaysRun=true)
	public void BeforeTest() {
		System.out.println("@BeforeTest");
	}
	
	
	
	@BeforeClass(alwaysRun=true)
	public void BeforeClass() {
		System.out.println("@BeforeClass");
	}
	
	
	@AfterClass(alwaysRun=true)
	public void AfterClass() {
		System.out.println("@AfterClass");
	}
	
	@BeforeMethod(alwaysRun=true)
	public void BeforeMethod() {
		System.out.println("@BeforeMethod");
	}
	
	@AfterMethod(alwaysRun=true)
	public void AfterMethod() {
		System.out.println("@AfterMethod");
	}
	

	@Test(priority=2,description="Login",invocationCount=3,invocationTimeOut=60,enabled=true,groups="SIT")
	public void Testcase4() throws InterruptedException
	{
		System.out.println("Test case 4");
		//Thread.sleep(8000);
	}
	
	@Test(priority=1,description="Login",enabled=true,groups="Sanity")
	public void Testcase2() throws InterruptedException
	{
		System.out.println("Test case 2");
		//Thread.sleep(8000);
	}
	@Test(priority=-1,description="Login",enabled=true,groups={"Sanity","SIT"})
	public void Testcase3() throws InterruptedException
	{
		System.out.println("Test case 3");
		//Thread.sleep(8000);
	}
	
	@Test(priority=-2,description="forgotPassword",timeOut=60,dependsOnMethods="Testcase2",groups="Sanity")
	public void Testcase1()
	{
		System.out.println("Test case 1");
	}
	
}
