package pages;
import java.time.Duration;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import base.BaseTest;

public class SearchPage extends BaseTest{
	
	public SearchPage(WebDriver driver)
	{
		this.driver = driver;
		this.wait = new WebDriverWait(driver,Duration.ofSeconds(15));
	}
	
	By Destination1 = By.xpath("(//div[@class='srcDestWrapper___e67e69'])[1]");
	By Destination2 = By.xpath("(//div[@class='srcDestWrapper___e67e69'])[2]");
	By dateofjourney = By.xpath("//*[text()='Date of Journey']");
	By BookingforWomen = By.cssSelector("div[role=switch]");
	By BookingWomenaccept = By.xpath("//button[text()='Got it']");
			//By.cssSelector("button.primaryButton___3262c2");
	By searchbuses = By.cssSelector("button[class='primaryButton___3262c2 searchButtonWrapper___90670b ']");
	
	
	public void enterSource(String from) throws InterruptedException {
		
	    WebElement fromBox = wait.until(ExpectedConditions.elementToBeClickable(Destination1));
	    fromBox.click();

	    List<WebElement> cityList = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(
	        By.xpath("//div[@class='listHeader___90a8b7']")));

	    for (WebElement city : cityList) {
	        String name = city.getText().trim();
	//        System.out.println("City found: " + name);
	        if (name.equalsIgnoreCase(from)) {
	            city.click();
	            System.out.println("Clicked on: " + from);
	            break;
	        }
	    }
	}
	public void enterDestination(String to)
	{
		    WebElement fromBox = wait.until(ExpectedConditions.elementToBeClickable(Destination2));
		    fromBox.click();

		    List<WebElement> cityList = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(
		        By.xpath("//div[@class='listHeader___90a8b7']")));

		    for (WebElement city : cityList) {
		        String name = city.getText().trim();
		    //    System.out.println("City found: " + name);
		        if (name.equalsIgnoreCase(to)) {
		            city.click();
		            System.out.println("Clicked on: " + to);
		            break;
		        }
		    }
	}
	public void dateofJourney(String MonethYear,String Day) throws InterruptedException
	{
		WebElement date = wait.until(ExpectedConditions.elementToBeClickable(dateofjourney));
		date.click();
		selectDate(MonethYear,Day);
		click(BookingforWomen);
		click(BookingWomenaccept);
		click(searchbuses);
		Thread.sleep(5000);
	}
}