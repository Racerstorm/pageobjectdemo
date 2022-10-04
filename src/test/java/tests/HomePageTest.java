package tests;

import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.*;

import pages.BaseClass;
import pages.HomePage;
import pages.LoginPage;
import utilities.ConfigDataProvider;

public class HomePageTest extends BaseClass {
	LoginPage loginObj;
	HomePage homepageObj;
	
	@BeforeMethod
	public void logintoApplication()
	{
		loginObj= PageFactory.initElements(driver, LoginPage.class);
		loginObj.login(confData.getDatafromConfig("username"),confData.getDatafromConfig("password"));	
		
	}
	
	@Test(priority=1)
	public void verifyPageTitle()
	{
		String title = "DeOrangehRM";
		try
		{
		System.out.println("Inside first testcase");
		logger=report.createTest("Verify Page Title on Homepage");
		logger.info("Verifying the title - <br>"+ "Expected title : "+driver.getTitle()+"<br>Actual Title : "+title+"<br>");
		Assert.assertEquals(driver.getTitle(), title);
		//logger.pass("Page title verified successfully");
		System.out.println("First testcase done");
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
	}
	
	@Test(priority=2)
	public void enterEmployeeInfo()
	{
		System.out.println("Inside second testcase");
		logger=report.createTest("Fill in employee details");
		homepageObj = PageFactory.initElements(driver, HomePage.class);
		homepageObj.fillemployeeDetails(confData.getDatafromConfig("empName"),confData.getDatafromConfig("empID"));
		System.out.println("Second testcase done");
	}
		
	}
	

