package rahushettyacademy.TestComponents;

import org.testng.annotations.AfterMethod;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;


import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.apache.commons.io.FileUtils;

import rahushettyacademy.pageobjects.LandingPage;

public class BaseTest {
	
	public WebDriver driver;
	public LandingPage landingPage;
	

	public WebDriver initializeDriver() throws IOException
	{
		Properties prop = new Properties();
		FileInputStream fis = new FileInputStream ("/Users/anhchau/eclipse/StudySelenium/SeleniumFrameworkDesign2/SeleniumFrameworkDesign/src/test/java/rahulshettyacademy/Resources/GlobalData.properties");
		prop.load(fis);
		String BrowserName = prop.getProperty("browser");
		
		if(BrowserName.equalsIgnoreCase("chrome"))
		{
			driver = new ChromeDriver();
			
		}
		else if (BrowserName.equalsIgnoreCase("firefox"))
		
		{
			//Open firefox
		}
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
		return driver;
		
	}
	
	public String getScreenshot (String testCaseName,WebDriver driver2) throws IOException
	{
		TakesScreenshot ts = (TakesScreenshot)driver2;
		File source = ts.getScreenshotAs(OutputType.FILE);
		File file = new File(System.getProperty("user.dir" +"//reports//"+testCaseName+".png"));
		FileUtils.copyFile(source,file);
		return System.getProperty("user.dir" +"//reports//"+testCaseName+".png");
	}
	
	@BeforeMethod
	public LandingPage launchApplication() throws IOException
	{
		driver = initializeDriver();
		landingPage = new LandingPage (driver);
		landingPage.toGo();
		return landingPage;
	}
	
	
	@AfterMethod
	public void tearDown()
	{
		driver.close();
	}

}
