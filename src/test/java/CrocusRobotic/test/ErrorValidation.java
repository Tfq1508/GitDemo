package CrocusRobotic.test;

import java.io.IOException;

import org.testng.annotations.Test;



import CrocusRobotic.TestComponents.BaseTest;
import CrocusRobotic.pageobjects.LandingPage;
import CrocusRobotic.pageobjects.ProductCataloge;
import Utilities.Retry;

import org.testng.Assert;


public class ErrorValidation extends BaseTest {

	@Test(retryAnalyzer=Retry.class)
public void submitOrder() throws IOException {
		String productName= "IPHONE 13 PRO";
		landpage.loginApplication("abc@gmail.com", "Abc@#12");
		Assert.assertEquals("Incorrect email o password.", landpage.getErrorMessage());
	}


}
