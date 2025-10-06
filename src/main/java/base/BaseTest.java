package base;
import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
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
	public WebDriverWait getWait()
	{
		return wait;
	}
}
