package test;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import base.BaseTest;
import pages.BookingPage;
import pages.BusResultPage;
import pages.SearchPage;

public class SearchTest extends BaseTest {
	
	SearchPage search; 
	BusResultPage busresult;
	BookingPage bookingpage;
	
	@BeforeTest
	public void start()
	{
		openBrowser();
		search = new SearchPage(driver);
		busresult = new BusResultPage(driver);
		bookingpage = new BookingPage(driver); 
	}
	@Test(priority=0)
	public void searchbus() throws InterruptedException
	{
		search.enterSource("Akola");
		search.enterDestination("Pune");
		search.dateofJourney("November 2025","17");
	}
	@Test(priority=1,dependsOnMethods= {"searchbus"})
	public void resultbus() throws InterruptedException
	{
		busresult.resultBus();
		busresult.Highestbusticket();
		busresult.Lowestbusticket();
		bookingpage.SelectBus(busresult.getCheapestBusElement());
		bookingpage.SelectSeat();
		bookingpage.selectboardingpoint();
		bookingpage.PassengerInfo();
	}
	@AfterTest
	public void end()
	{
		closeBrowser();
	}
}
