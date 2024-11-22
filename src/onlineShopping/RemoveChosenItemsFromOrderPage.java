package onlineShopping;

import java.time.Duration;
import java.util.List;
import java.util.stream.Stream;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

public class RemoveChosenItemsFromOrderPage {
	@Test
	public void RemoveChosenItems() {
		String productsName = "ZARA COAT 3";
	//Login to https://rahulshettyacademy.com/client
	WebDriver driver = new ChromeDriver();
	driver.get("https://rahulshettyacademy.com/client");
	driver.findElement(By.id("userEmail")).sendKeys("anh.chau@gmail.com");
	driver.findElement(By.id("userPassword")).sendKeys("123456");
	driver.findElement(By.id("login")).click();
	WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(3));
	wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.cssSelector(".mb-3")));
	//add some items to Carts
	List<WebElement> products = driver.findElements(By.cssSelector(".mb-3"));
	WebElement prod =products.stream().filter(product->product.findElement(By.cssSelector("b")).getText().equals(productsName)).findFirst().orElse(null);
	prod.findElement(By.cssSelector(".card-body button:last-of-type")).click();
	wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("#toast-container")));
	wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector(".ng-animating")));
	driver.findElement(By.cssSelector("[routerlink*='cart']")).click();
	List<WebElement> product = driver.findElements(By.cssSelector(".cartSection h3"));
	System.out.println(Stream.of(product));
	boolean match =product.stream().anyMatch(s->s.getText().equalsIgnoreCase(productsName));
	//Assert.assertTrue(match);

	// Go to Verify they are in Order page 
	
	  driver.findElement(By.cssSelector("[routerlink*='myorders']")).click();
	  
	  List<WebElement> addedProd =
	  driver.findElements(By.cssSelector("td:nth-child(3)"));
	  
	  boolean match2
	  =addedProd.stream().anyMatch(s->s.getText().equalsIgnoreCase(productsName));
	  addedProd.stream().filter(s->s.getText().equals(productsName)).forEach(s->
	  System.out.println(s));
	  
	  Assert.assertTrue(match2);
	  
	  //Checkout and verify checkout successfully
	 	}
}
