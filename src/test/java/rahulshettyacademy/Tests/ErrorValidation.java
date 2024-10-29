package rahulshettyacademy.Tests;


import org.testng.annotations.Test;
import org.testng.Assert;

import java.io.IOException;

import rahushettyacademy.TestComponents.BaseTest;


public class ErrorValidation extends BaseTest {

	@Test 
	public void LoginErrorValidation() throws IOException {
		// TODO Auto-generated method stub
		landingPage.loginApplication("anh.chau@gmail.com", "abc");
		Assert.assertEquals("incorrect",landingPage.getErrorMessage() );

	}

}
