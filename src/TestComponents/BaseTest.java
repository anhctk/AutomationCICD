package TestComponents;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

public class BaseTest {
	public static WebDriver driver;
	
	public WebDriver initizeDriver() throws IOException {
		
		Properties prop = new Properties();
		FileInputStream fis = new FileInputStream (System.getProperty("user.dir")+"/src/resources/GlobalData.properties");
		prop.load(fis);
		String browserName =prop.getProperty("browser");
		
		if (browserName.equalsIgnoreCase("chrome"))
		{
			 driver = new ChromeDriver();
			 driver.manage().window().maximize();
		}
		else if (browserName.equalsIgnoreCase("firefox"))
		{
			//Firefox
		}
		else if (browserName.equalsIgnoreCase("edge"))
		{
			//Edge
		}
		return driver;
	}
	
	@BeforeTest
	public void lunchApplication() throws IOException {
		driver = initizeDriver() ;
		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/");
	
	}
	//@AfterTest
	public void exitApplication()
	{
		driver.close();
	}
	public static String getScreenshot(String testcaseName, WebDriver driver) throws IOException {
		TakesScreenshot ts =  (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		File file = new File(System.getProperty("user.dir")+"/reports/"+testcaseName+".png");
		FileUtils.copyFile(source,file);
		return System.getProperty("user.dir")+"/reports/"+testcaseName+".png";
	}

}
