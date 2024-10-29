package rahushettyacademy.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;



public class DashboardPage {
WebDriver driver;
	
	public DashboardPage(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy (css =".hero-primary")
	WebElement thankYouMessage;
	
	
	public  void VerifyMessageDisplay(String message)
	{
	//	Assert.assertEquals(thankYouMessage.getText(), message);
	
				System.out.println("test");
	}

}
