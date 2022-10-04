package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage {

	WebDriver driver;
	public LoginPage(WebDriver driver) //Whenever a loginpage object is created, this constructor gets called. Webdriver instance from the other class would be handed over to the local driver instance
	{
		this.driver=driver;
	}
	
	//Capture locators
	@FindBy(name="username") WebElement usernameLocator;
	@FindBy(name="password") WebElement passwordLocator;
	@FindBy(xpath="//button[@type='submit']") WebElement submitbtn;
	
	
//	By usernameLocator = By.name("username");
//	By passwordLocator = By.name("password");
//	By submitbtn = By.xpath("//button[@type='submit']");
	
	public void login(String username,String password)
	{
		usernameLocator.sendKeys(username);
		passwordLocator.sendKeys(password);
		submitbtn.click();
		
	}
}
