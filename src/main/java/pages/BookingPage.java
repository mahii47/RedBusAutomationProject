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

public class BookingPage extends BaseTest{
	
	By specificseat = By.cssSelector("span[id=\"3\"]");
	By crosssign =  By.xpath("(//button[@class='actionButton___1b54f5  action___cd46a7'])[3]");
	By button = By.cssSelector("button[class ='primaryButton___3262c2 button___2b7236 ']");
	By boardpoint = By.xpath("//div[@data-id='0']//label");
	By droppoint = By.xpath("(//div[@class='bpdpContainer___e8fcb2'])[2]//div[@data-id='0']//label");
	By phone = By.id("0_6");
	By email = By.id("0_5");
	By name = By.id("0_4");
	By age = By.id("0_1");
	By gender = By.xpath("//div[@aria-label='Female']");
	By freeCancellation = By.xpath("(//*[@class='fcSubheader___7e52e7'])[2]");
	By redbusassurance = By.id("insuranceRejectText");
	By donation = By.xpath("(//*[@class='switchLabel___a8ead2 unChecked___09ee04 enabled___ad293b '])[2]");
	By continuebutton = By.xpath("(//button[@class='primaryButton___3262c2  '])[2]");
	
	public BookingPage(WebDriver driver) {
		this.driver = driver;
		this.wait = new WebDriverWait(driver,Duration.ofSeconds(15));
	}
	public void SelectBus(WebElement cheapestBusElement) throws InterruptedException
	{
		try {
	        WebElement overlayCloseButton = driver.findElement(By.xpath("//div[contains(@class,'modifySearch')]"));
	        if (overlayCloseButton.isDisplayed()) {
	            ((JavascriptExecutor) driver).executeScript("arguments[0].style.display='none';", overlayCloseButton);
	        }
	    } catch (Exception e) {
	       
	    }
	    WebElement cheapestBusButton = cheapestBusElement.findElement(By.xpath(".//button[contains(@class,'viewSeatsBtn')]"));
	    JavascriptExecutor js = (JavascriptExecutor) driver;
	    js.executeScript("arguments[0].scrollIntoView({block: 'center'});", cheapestBusButton);
	    Thread.sleep(500);
	    wait.until(ExpectedConditions.elementToBeClickable(cheapestBusButton));	   
	    cheapestBusButton.click();
	}
	public void selectboardingpoint() throws InterruptedException
	{
		WebElement board = wait.until(ExpectedConditions.elementToBeClickable(boardpoint));	
		board.click();
		WebElement drop =  wait.until(ExpectedConditions.elementToBeClickable(droppoint));	
		drop.click();
		try {
		WebElement passengerbutton =  wait.until(ExpectedConditions.elementToBeClickable(button)); 
		passengerbutton.click();
		}catch(Exception e)
		{
			
		}
		Thread.sleep(2000);
	}
	
	public void SelectSeat() {
	    try {
	        // Close pop-up if present
	        WebElement cross = wait.until(ExpectedConditions.elementToBeClickable(crosssign));
	        cross.click();
	    } catch (Exception e) {
	  
	    }

	    try {
	      
	        List<WebElement> seats = wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(
	                By.cssSelector("span[class*='sleeper__ind-seat']")));

	        boolean seatSelected = false;

	        for (WebElement seat : seats) {
	            String ariaLabel = seat.getAttribute("aria-label");

	            if (ariaLabel != null && ariaLabel.toLowerCase().contains("available")) {
	                System.out.println("Available seat found: " + ariaLabel);

	                wait.until(ExpectedConditions.elementToBeClickable(seat)).click();
	                seatSelected = true;
	                break;
	            }
	        }

	        if (!seatSelected) {
	            System.out.println("No available seats found.");
	        }
	        WebElement pointsbutton = wait.until(ExpectedConditions.elementToBeClickable(button));
	        pointsbutton.click();

	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	}
	public void PassengerInfo() throws InterruptedException
	{
		WebElement Phone = wait.until(ExpectedConditions.elementToBeClickable(phone));
		Phone.click();
		Phone.sendKeys("7758937720");
		WebElement Email = wait.until(ExpectedConditions.elementToBeClickable(email));
		Email.sendKeys("mahmankar333@gmail.com");
		WebElement dropdown = driver.findElement(By.xpath("//div[@class='gstWrap___478b5c']"));
		dropdown.click();
		Thread.sleep(5000);
		driver.findElement(By.xpath("//div[@data-radio-index='0']//label")).click();
		WebElement Name = wait.until(ExpectedConditions.elementToBeClickable(name));
		Name.sendKeys("Mahesh");
		WebElement Age = wait.until(ExpectedConditions.elementToBeClickable(age));
		Age.sendKeys("27");
		try {
		WebElement Gender = wait.until(ExpectedConditions.elementToBeClickable(gender));
		Gender.click();
		}catch(Exception e){
			
		}
		try {
		WebElement FreeCancellation =  wait.until(ExpectedConditions.elementToBeClickable(freeCancellation));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", FreeCancellation);
		Thread.sleep(1000); // optional delay for stability
		FreeCancellation.click();
		}catch(Exception e)
		{
			
		}
		try {
		WebElement Redbusassurance = wait.until(ExpectedConditions.elementToBeClickable(redbusassurance));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", Redbusassurance);
		Thread.sleep(1000);
		Redbusassurance.click();
		}catch(Exception e)
		{
			
		}
		WebElement Donation = wait.until(ExpectedConditions.elementToBeClickable(donation));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", Donation);
		Thread.sleep(1000);
		Donation.click();
		
		WebElement ContinueButton = wait.until(ExpectedConditions.elementToBeClickable(continuebutton));
		ContinueButton.click();
	}
}
