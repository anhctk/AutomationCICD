package pageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class CountryPage {
	
	WebDriver driver;
	
	public CountryPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
//@FindBy (xpath="//div[@class='wrapperTwo']/div/select")
//	private WebElement ObjSelect;
//	Select dropdown= new Select (ObjSelect);
	
	@FindBy (css=".chkAgree")
	WebElement agreeChekbox;
	@FindBy (xpath="//button[text()='Proceed']")
	WebElement proceedBnt;
	//Select ObjSelect =new Select (driver.findElement(By.xpath("//div[@class='wrapperTwo']/div/select")));
	//WebElement agreeChekbox = driver.findElement(By.cssSelector(".chkAgree"));
	//WebElement proceedBnt =driver.findElement(By.xpath("//button[text()='Proceed']"));
	
	public void selectCountryandProceed(String country)
	{
		//dropdown.selectByValue(country);
		agreeChekbox.click();
		proceedBnt.click();
		
	}
	
}
