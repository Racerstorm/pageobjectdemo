package utilities;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;

import org.apache.poi.xssf.usermodel.*;

public class ConfigDataProvider {
	
	Properties prop;
	ConfigDataProvider conf;
	public  ConfigDataProvider()
	{
		this.conf=conf;
		try
		{	
			File src = new File("./config/config.properties");
			FileInputStream fis = new FileInputStream(src);
			prop=new Properties();
			prop.load(fis);
		} 
		
		catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	public String getDatafromConfig(String paramName)
	{
		return prop.getProperty(paramName);
	}

}
