package pageObjects;

import java.util.List;

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
	

	

	@FindBy(css=".promoCode")
	WebElement promoCode;
	


	@FindBy(css="//button[text()='Apply']")
	WebElement applyBnt;


	@FindBy(xpath="//button[text()='Place Order']")
	WebElement placeOrderBnt ;
	
	@FindBy(css="tr td:nth-child(2)")
	private static List<WebElement> productNames;
	
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
	public static Boolean verifyProductAdded(String productname) {
		
		Boolean match =productNames.stream().anyMatch(product ->product.getText().equalsIgnoreCase(productname));
		return match;
			
		}

	
	
	

}
