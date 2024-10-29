package rahushettyacademy.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import rahushettyacademy.AbstractComponents.AbstractComponent;

public class CheckoutPage extends AbstractComponent {
	WebDriver driver;

	public CheckoutPage (WebDriver driver)
	{
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy (css="[placeholder='Select Country']")
	WebElement selectCountry;
	@FindBy (css=".action__submit")
	WebElement PlaceHolderButton;

	public void Checkout( String country)
	{
		Actions a = new Actions(driver);
		a.sendKeys(selectCountry, country).build().perform();
		driver.findElement(By.cssSelector(".ta-item:nth-of-type(2)")).click();
	
		
		
	}
	
	public DashboardPage SubmitOrder()
	{
		PlaceHolderButton.click();

		return new DashboardPage(driver);
	}
	
}
