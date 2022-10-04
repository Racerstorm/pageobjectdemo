package utilities;

import java.io.File;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.FileHandler;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class actionsHelper {
	
	public static String captureScreenshot(WebDriver driver)
	{
		
		File screenshotsrc = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		String screenshotPath = System.getProperty("user.dir")+"TestReport_"+getCurrentDateandTime()+".png";
		try
		{
		FileUtils.copyFile(screenshotsrc, new File(screenshotPath));
		}
		
		catch(Exception e)
		{
			System.out.println("Failed with exception : "+e);
		}
		return screenshotPath;
	}
	
	public static String getCurrentDateandTime()
	{
		DateFormat customdatepattern = new SimpleDateFormat("dd_MM_yyyy_HH_mm_ss");
		Date currentDate = new Date();
		return customdatepattern.format(currentDate);
	}
	

}
