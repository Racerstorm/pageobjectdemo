package tests;

import org.testng.annotations.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.*;

import pages.BaseClass;
import pages.LoginPage;
import utilities.BrowserFactory;

public class LoginPageTest extends BaseClass{
	
	
	@Test
	public void verifytitle()
	{
		
		//Initialize web elements in the class. This method returns the object of the class passed in the parameter.
		LoginPage loginInstance = PageFactory.initElements(driver, LoginPage.class);
		Assert.assertEquals(driver.getTitle(), "Login");
		
		
	}
	@Test
	public void logintoApplication()
	{
		
		//Initialize web elements in the class. This method returns the object of the class passed in the parameter.
		LoginPage loginInstance = PageFactory.initElements(driver, LoginPage.class);
		loginInstance.login("admin", "admin123");
		
		
	}
	
}
