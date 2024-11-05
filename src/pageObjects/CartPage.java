package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CartPage {
	
	WebDriver driver;
	public CartPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	

	//WebElement promoCode = driver.findElement(By.cssSelector(".promoCode"));
	@FindBy(css=".promoCode")
	WebElement promoCode;
	
	//WebElement applyBnt = driver.findElement(By.cssSelector("//button[text()='Apply']"));
	@FindBy(css="//button[text()='Apply']")
	WebElement applyBnt;
	//WebElement placeOrderBnt = driver.findElement(By.xpath("//button[text()='Place Order']"));
	
	@FindBy(xpath="//button[text()='Place Order']")
	WebElement placeOrderBnt ;
	public CountryPage placeOrder(String code) throws InterruptedException {
		Boolean r = code.isBlank();
		if (r=false) 
		{
			promoCode.sendKeys(code);
			applyBnt.click();
		}
		Thread.sleep(3000);
		placeOrderBnt.click();
	return new CountryPage(driver);
		
	}
	
	
	
	

}
