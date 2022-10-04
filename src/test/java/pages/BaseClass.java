package pages;

import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.*;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import utilities.BrowserFactory;
import utilities.ConfigDataProvider;
import utilities.actionsHelper;

public class BaseClass {
//Purpose of the base class is to execute the pre and post conditions once for all test cases. This reduces the code needed for browser launch and termination
public WebDriver driver;
public ConfigDataProvider confData;
public ExtentReports report;
public ExtentTest logger;
public String steplogmessage;
	
@BeforeSuite
public void setupSuite()
{
	confData = new ConfigDataProvider();
    //HTML Reporting
	report= new ExtentReports();
	ExtentSparkReporter sparkReport = new ExtentSparkReporter("./Reports/testreport"+actionsHelper.getCurrentDateandTime()+".html");
	report.attachReporter(sparkReport);
	
}
@BeforeMethod
public void setup()
	{
		//Using inheritance
		//driver = b.launchBrowser(driver, appURL, "Chrome");
		
		//Without inheritance
		driver = BrowserFactory.launchBrowser(driver, confData.getDatafromConfig("appURL"), confData.getDatafromConfig("browser"));
	}

@AfterMethod
public void tearDownMethod(ITestResult result)
{
	if(result.getStatus() ==ITestResult.FAILURE)
	{
		actionsHelper.captureScreenshot(driver);
		logger.fail("Test failed. ", MediaEntityBuilder.createScreenCaptureFromPath(actionsHelper.captureScreenshot(driver)).build());
		
		
	}
	
	else if(result.getStatus() ==ITestResult.SUCCESS)
	{
		actionsHelper.captureScreenshot(driver);
		logger.pass("Test passed. ", MediaEntityBuilder.createScreenCaptureFromPath(actionsHelper.captureScreenshot(driver)).build());
		
	}
	
	if(result.getStatus() ==ITestResult.SKIP)
	{
		actionsHelper.captureScreenshot(driver);
		logger.skip("Test skipped. ", MediaEntityBuilder.createScreenCaptureFromPath(actionsHelper.captureScreenshot(driver)).build());
		
	}
	steplogmessage="";
	report.flush();
}
	
	
	@AfterClass
	public void tearDown()
	{
		BrowserFactory.quitBrowser(driver);
	}

	
}
