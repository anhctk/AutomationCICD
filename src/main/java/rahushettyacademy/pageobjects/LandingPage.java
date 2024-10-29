package rahushettyacademy.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import rahushettyacademy.AbstractComponents.AbstractComponent;


public class LandingPage extends AbstractComponent  {
	WebDriver driver;

	public LandingPage (WebDriver driver)
	{
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(id="userEmail")
	WebElement userEmail;
	@FindBy(id="userPassword")
	WebElement userPassword;
	@FindBy(id="login")
	WebElement login;
	
	@FindBy(css="[class*='flyInOut']")
	WebElement errorMessage;
	
	public void toGo()
	{
		driver.get("https://rahulshettyacademy.com/client");
	}
	
	public String getErrorMessage()
	{
		waitForElementToAppear(errorMessage);
		String error = errorMessage.getText();
		return error;
	}
	
	public ProductCatalouge loginApplication(String username,String password)
	{
		userEmail.sendKeys(username);
		userPassword.sendKeys(password);
		login.click();
		ProductCatalouge productCatalouge = new ProductCatalouge (driver);
		return productCatalouge;
	}
	
	
}
