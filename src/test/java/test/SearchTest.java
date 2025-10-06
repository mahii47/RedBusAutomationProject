package test;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import base.BaseTest;
import pages.SearchPage;

public class SearchTest extends BaseTest {
	
	SearchPage search; 
	
	@BeforeTest
	public void start()
	{
		openBrowser();
		search = new SearchPage(driver);
	}
	@Test
	public void searchbus() throws InterruptedException
	{
		search.enterSource("Pune");
		search.enterDestination("Mumbai");
	}
	@AfterTest
	public void end()
	{
		closeBrowser();
	}
}
