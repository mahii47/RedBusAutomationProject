package pages;
import java.time.Duration;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
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
	By searchbuses = By.cssSelector("button[class='primaryButton___3262c2 searchButtonWrapper___90670b ']");
	
	public void enterSource(String from) throws InterruptedException {
	
		WebElement fromBox = wait.until(ExpectedConditions.elementToBeClickable(Destination1));
	    fromBox.click();
	    WebElement fromInput = wait.until(ExpectedConditions.elementToBeClickable(By.id("srcDest")));
		WebElement mainbox = wait.until(ExpectedConditions.elementToBeClickable(fromInput));
		mainbox.sendKeys(from);
		Thread.sleep(2000);
	    
	    List<WebElement> cityList = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(
		        By.xpath("//div[@class='listHeader___90a8b7']")));
	
		    for (WebElement city : cityList) {
		       String name = city.getText().trim();
		        if(name.toLowerCase().contains(from.toLowerCase())) {
		            city.click();
		            System.out.println("Selected sourceCity is: " + from);
		            break;
		        }
		    }
	}
	public void enterDestination(String to) throws InterruptedException
	{
		    WebElement fromBox = wait.until(ExpectedConditions.elementToBeClickable(Destination2));
		    fromBox.click();
		    
		    WebElement fromInput = wait.until(ExpectedConditions.elementToBeClickable(By.id("srcDest")));
			WebElement mainbox = wait.until(ExpectedConditions.elementToBeClickable(fromInput));
			mainbox.sendKeys(to);
			Thread.sleep(2000);
			
		    List<WebElement> cityList = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(
		        By.xpath("//div[@class='listHeader___90a8b7']")));

		    for (WebElement city : cityList) {
		        String name = city.getText().trim();
		        if (name.toLowerCase().contains(to.toLowerCase())) {
		            city.click();
		            System.out.println("Selected destinationCity is: " + to);
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