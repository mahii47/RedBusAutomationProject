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

public class BusResultPage extends BaseTest{
	 WebElement cheap;
	 String cheapestBus = "";
	 public  WebElement cheapestBusElement = null; 

	public BusResultPage(WebDriver driver)
	{
		this.driver = driver;
		this.wait = new WebDriverWait(driver,Duration.ofSeconds(15));
	}
	public void resultBus() throws InterruptedException
	{	
		  JavascriptExecutor js = (JavascriptExecutor) driver;

	        long lastHeight = (long) js.executeScript("return document.body.scrollHeight");

	        while (true) {
	           
	        	for(int i=0;i<5;i++)
	        	{
	            js.executeScript("window.scrollBy(0,500);");
	            Thread.sleep(1000); 
	        	}
	            long newHeight = (long) js.executeScript("return document.body.scrollHeight");
	            if (newHeight == lastHeight) {
	                break; 
	            }
	            lastHeight = newHeight;
	        }
	        List<WebElement> allBuses = driver.findElements(By.xpath("//li[contains(@class,'tupleWrapper')]"));
	        System.out.println("Total buses loaded: " + allBuses.size());
	        System.out.println("------------------------------------------------------------");

	        for (WebElement bus : allBuses) {
	            System.out.println(bus.getText()); 
	            System.out.println("------------------------------------------------------------");
	        }
	}
	public void Lowestbusticket() throws InterruptedException
	{	
		List<WebElement> buses = driver.findElements(By.xpath("//li[contains(@class,'tupleWrapper')]"));
		double minPrice = Double.MAX_VALUE;
	

		for (WebElement bus : buses) {
		    String priceText = bus.findElement(By.xpath(".//p[contains(@class,'finalFare')]")).getText(); // 499
		    priceText = priceText.replaceAll("[^0-9]", ""); // Remove  and other chars
		    double price = Double.parseDouble(priceText);

		    if (price < minPrice) {
		        minPrice = price;
		        cheapestBus = bus.findElement(By.xpath(".//div[contains(@class,'travelsName')]")).getText();
		        cheap = bus.findElement(By.xpath(".//div[contains(@class,'travelsName')]"));
		        cheapestBusElement = bus;
		    }
		}
		System.out.println("-----------------Cheapest Bus Ticket-------------------------------------------");
		System.out.println("Cheapest Bus ticket: " + cheapestBus + " - Price: " + minPrice);
		System.out.println("--------------------------------------------------------------------------------");
		
		Thread.sleep(5000);
	
	}
	
	public WebElement getCheapestBusElement()
	{
		return cheapestBusElement;
	}
	public void Highestbusticket()
	{
		List<WebElement> buses = driver.findElements(By.xpath("//li[contains(@class,'tupleWrapper')]"));
		double minPrice = Double.MIN_VALUE;
		String highestBus = "";

		for (WebElement bus : buses) {
		    String priceText = bus.findElement(By.xpath(".//p[contains(@class,'finalFare')]")).getText(); // 499
		    priceText = priceText.replaceAll("[^0-9]", ""); 
		    double price = Double.parseDouble(priceText);

		    if (price > minPrice) {
		        minPrice = price;
		        highestBus = bus.findElement(By.xpath(".//div[contains(@class,'travelsName')]")).getText();
		    }
		}
		System.out.println("-----------------Expensive Bus Ticket-------------------------------------------");
		System.out.println("Expensive Bus ticket: " + highestBus + " - Price: " + minPrice);
		System.out.println("--------------------------------------------------------------------------------");
	}
}