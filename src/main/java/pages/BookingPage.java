package pages;

import java.time.Duration;

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


	public BookingPage(WebDriver driver) {
		// TODO Auto-generated constructor stub
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
	    System.out.println("Clicked on the cheapest bus button successfully.");
	}
	
	public void SelectSeat()
	{
		try
		{
			WebElement cross =  wait.until(ExpectedConditions.elementToBeClickable(crosssign));
			cross.click();
		}catch(Exception e)
		{
			
		}
	
		WebElement seat = wait.until(ExpectedConditions.elementToBeClickable(specificseat));
		seat.click();
		
		WebElement pointsbutton = wait.until(ExpectedConditions.elementToBeClickable(button));
		pointsbutton.click();
		
	}
	public void selectboardingpoint()
	{
		WebElement board = wait.until(ExpectedConditions.elementToBeClickable(boardpoint));	
		board.click();
		WebElement drop =  wait.until(ExpectedConditions.elementToBeClickable(droppoint));	
		drop.click();
		WebElement pointsbutton = wait.until(ExpectedConditions.elementToBeClickable(button));
		pointsbutton.click();
	}
}
