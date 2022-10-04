package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage {
	WebDriver driver;
	public  HomePage(WebDriver driver)
	{
		this.driver=driver;
	}
	
	@FindBy(xpath=".//div[@class='oxd-autocomplete-text-input oxd-autocomplete-text-input--active']/input") WebElement empName;
	@FindBy(xpath="(//input[@class='oxd-input oxd-input--active'])[2]") WebElement empID;


	public void fillemployeeDetails(String empname,String empid)
	{
		empName.sendKeys(empname);
		empName.sendKeys(empid);
	}
}