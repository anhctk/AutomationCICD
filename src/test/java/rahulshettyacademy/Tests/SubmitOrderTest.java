package rahulshettyacademy.Tests;


import org.testng.annotations.Test;
import java.io.IOException;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

import rahushettyacademy.TestComponents.BaseTest;
import rahushettyacademy.pageobjects.CartPage;
import rahushettyacademy.pageobjects.CheckoutPage;
import rahushettyacademy.pageobjects.DashboardPage;
import rahushettyacademy.pageobjects.LandingPage;
import rahushettyacademy.pageobjects.ProductCatalouge;

public class SubmitOrderTest extends BaseTest {

	@Test
	public void SubmitOrder() throws IOException, InterruptedException {
		//add my comments to demo jenkins
		// TODO Auto-generated method stub
		String productName = "ZARA COAT 3";
		String country ="india";
		String thankyouMessage = "THANKYOU FOR THE ORDER.";
		ProductCatalouge productCatalouge = landingPage.loginApplication("anh.chau@gmail.com", "123456");
	
		
		productCatalouge.addProductToCart(productName);
		CartPage cartPage= productCatalouge.gotoCartPage();
		
		
		Assert.assertTrue(cartPage.VerifyProductDisplay(productName));
		
		CheckoutPage checkoutPage = cartPage.goToCheckout();
		checkoutPage.Checkout(country);
		DashboardPage dashboardPage = checkoutPage.SubmitOrder() ;
		dashboardPage.VerifyMessageDisplay(thankyouMessage);
	

	
		

	}

}
