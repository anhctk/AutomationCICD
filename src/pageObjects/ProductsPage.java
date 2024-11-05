package pageObjects;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;
import pageObjects.CartPage;


public class ProductsPage {
	
	WebDriver driver;
	
	
	public ProductsPage (WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	

	@FindBy(css="div[class='product'] h4")
  List<WebElement> products;
	
	@FindBy(xpath="//button[text()='ADD TO CART']")
	List<WebElement>addToCartBnt;
	
	
	@FindBy(css=".cart-icon")
	WebElement cartBnt;
	
	@FindBy (xpath="//button[text()='PROCEED TO CHECKOUT']")
	WebElement CheckoutBnt;
	public void selectProduct (String product)
	{
		System.out.println(products);
		for(int i = 0;i< products.size();i++ )
		{
			String pr = products.get(i).getText();
			if (pr.contains(product))
			{
				addToCartBnt.get(i).click();
			}
		}
		
	}
	
	public CartPage proceedCheckout()
	{
		
		//Proceed checkout
		cartBnt.click();
		CheckoutBnt.click();
		return new CartPage(driver);
		
	}

}
