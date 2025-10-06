package test;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import base.BaseTest;
import pages.SearchPage;

public class SearchTest extends BaseTest {
	
	SearchPage sp = new SearchPage(driver);
	
	@BeforeTest
	public void start()
	{
	openBrowser();
	}
	
	@Test
	public void searchbus() throws InterruptedException
	{
		sp.enterSource("Pune");
		sp.enterDestination("Mumbai");
	}
	
	@AfterTest
	public void end()
	{
		closeBrowser();
	}

}
