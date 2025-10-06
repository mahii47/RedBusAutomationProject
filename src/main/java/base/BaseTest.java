package base;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;


public class BaseTest { 
	
	public static WebDriver driver;
	
	

	public void openBrowser()
	{
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.redbus.in/");
	}

	
	public void closeBrowser()
	{
		if(driver!=null)
		{
		 driver.quit();
		}
	}
	
}
