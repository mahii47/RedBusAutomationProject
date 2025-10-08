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
	
	public BookingPage(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver = driver;
		this.wait = new WebDriverWait(driver,Duration.ofSeconds(15));
	}
	public void SelectSeat(WebElement cheapestBusElement) throws InterruptedException
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
}
