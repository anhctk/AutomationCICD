package buyProducts;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.testng.Assert;
import org.testng.annotations.Test;

import TestComponents.BaseTest;
import pageObjects.CartPage;
import pageObjects.ProductsPage;


public class buySomeItemsAndCheckout extends BaseTest {
	
	@Test
	public void buySomeItems() throws InterruptedException 
	
	{
		//RUn CICD 2
		ProductsPage product = new ProductsPage(driver);
		List<String> productName = Arrays.asList("Brocolli","Tomato","Brinjal","Capsicum","Walnuts");
		productName.stream().forEach(s->{
			try {
				product.selectProduct(s);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		});
		product.proceedCheckout();
		
		CartPage cart = new CartPage(driver);
		
		
		
		//Verify items are added to Cart
		
		Boolean match =productName.stream().anyMatch(s->CartPage.verifyProductAdded(s));
		
		Assert.assertTrue(match);
		
	

	}
	/*
	 * TC1: Buy  items in Cart and checkout - Verify items are added to Cart -
	 * Verify correct prices
	 */




}
