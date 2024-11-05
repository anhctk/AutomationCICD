package buyProducts;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pageObjects.CartPage;
import pageObjects.CountryPage;
import pageObjects.ProductsPage;



public class buyVegetables6 {
	WebDriver driver = new ChromeDriver();
	
	@BeforeTest
	public void toGo() {
		
		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/");
		driver.manage().window().maximize();
	}
	
	@Test
	public  void buyVegan () throws InterruptedException {
		// TODO Auto-generated method stub
		
		
		String product1 = "Brocolli";
		String product2 = "Cucumber";
		String code = "";
		String country = "Japan";


		//Add one Brocolli and one Cucumber to Cart
		ProductsPage product = new ProductsPage(driver);
		
		product.selectProduct(product1);
		product.selectProduct(product2);
		product.proceedCheckout();
		
		CartPage cartpage = new CartPage(driver);
		cartpage.placeOrder(code);
		
//		CountryPage countryPage = new CountryPage(driver);
//		countryPage.selectCountryandProceed("Japan");
		
		Select ObjSelect =new Select (driver.findElement(By.xpath("//div[@class='wrapperTwo']/div/select")));
		WebElement agreeChekbox = driver.findElement(By.cssSelector(".chkAgree"));
		WebElement proceedBnt =driver.findElement(By.xpath("//button[text()='Proceed']"));
		ObjSelect.selectByValue(country);
		agreeChekbox.click();
		proceedBnt.click();
		
		String message = driver.findElement(By.xpath("//div[@class='wrapperTwo']/span")).getText();
		System.out.println( message);
 	   Boolean result =	message.contains("Thank you, your order has been placed successfully");
	   Assert.assertTrue(result);
	   
	}
	 @AfterTest
	   public void closePage()
	   {
		   driver.close();
	   }
	   
		
		

	

}
