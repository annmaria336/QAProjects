package AutomationCore;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.google.common.io.Files;

public class BaseClass {
public WebDriver driver;
public WebDriver browserInitilization(String browsername) 
{
	if(browsername.equalsIgnoreCase("chrome"))
	{
		driver=new ChromeDriver();
	}
	else if (browsername.equalsIgnoreCase("firefox"))
	
    {
        driver=new FirefoxDriver();		
     }
	else if (browsername.equalsIgnoreCase("edge"))
    {
        driver=new EdgeDriver();
     }
        else
     {
	System.out.println("invalid browser");
     }
	driver.manage().timeouts().implicitlyWait(2,TimeUnit.SECONDS);
return driver;
}	
public String getScreenshotPath(String testcasename, WebDriver driver) throws IOException {
TakesScreenshot ts=(TakesScreenshot)driver;
File source=ts.getScreenshotAs(OutputType.FILE);
String destinationfile=System.getProperty("user.dir")+"\\test-output\\"+testcasename+".png";
Files.copy(source, new File(destinationfile));
return destinationfile;
}
}
