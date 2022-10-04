package utilities;

import java.util.Collections;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BrowserFactory {
	
	public static WebDriver launchBrowser(WebDriver driver, String appURL, String browser)
	{
		if(browser.equalsIgnoreCase("chrome"))
		{
			
			//	DesiredCapabilities capability=DesiredCapabilities.chrome();
				WebDriverManager.chromedriver().setup();
				ChromeOptions options = new ChromeOptions();
				
				//Launch Canary
				//options.setBinary("C:\\Users\\ust52622\\AppData\\Local\\Google\\Chrome SxS\\Application\\chrome.exe");
				options.addArguments("--start-maximized");
				options.addArguments("disable-infobars");
				options.setExperimentalOption("useAutomationExtension", false); 
				options.setExperimentalOption("excludeSwitches", Collections.singletonList("enable-automation"));
				driver = new ChromeDriver(options);	
		}
		
		else if(browser.equalsIgnoreCase("Firefox"))
		{
			
			
		}
		
		driver.manage().window().maximize();
		driver.get(appURL);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.MINUTES);
		
		return driver;		
	}
	
	
	public static void quitBrowser(WebDriver driver)
	{
		driver.quit();
	}

}
