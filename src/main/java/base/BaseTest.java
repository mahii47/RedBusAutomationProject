package base;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class BaseTest { 
	
	protected  WebDriver driver;
	protected  WebDriverWait wait ;
	public void openBrowser()
	{
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.redbus.in/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		 wait = new WebDriverWait(driver, Duration.ofSeconds(15));
	}
	public void closeBrowser()
	{
		if(driver!=null)
		{
		 driver.quit();
		}
	}
	
	public void selectDate(String monthYear,String day)
	{
		WebElement calender = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@class='datepicker___d50075 '] ")));
		
		while(true)
		{
			WebElement currentMonthYear = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//p[contains(@class,'monthYear')]")));
			String currentMonth = currentMonthYear.getText();
			System.out.println("Current month is: "+currentMonth);
			
			if(monthYear.equals(currentMonth))
			{
				break;
			}
			
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//i[contains(@class,'right')]"))).click();
				break;
		}
		
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[contains(@class,'calendarDate') and not(contains(@class,'disabled'))]//span[text()='" + day + "']"))).click();
	}
	
	public void click(By clickbutton)
	{
		WebElement button = wait.until(ExpectedConditions.elementToBeClickable(clickbutton));
		button.click();
	}
	
}
