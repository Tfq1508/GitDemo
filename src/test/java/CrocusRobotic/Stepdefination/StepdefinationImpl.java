package CrocusRobotic.Stepdefination;

import java.io.IOException;
import java.util.List;

import org.testng.Assert;
import org.openqa.selenium.WebElement;

import CrocusRobotic.TestComponents.BaseTest;
import CrocusRobotic.pageobjects.CartPage;
import CrocusRobotic.pageobjects.CheckoutPage;
import CrocusRobotic.pageobjects.ConfirmationPage;
import CrocusRobotic.pageobjects.LandingPage;
import CrocusRobotic.pageobjects.ProductCataloge;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class StepdefinationImpl extends BaseTest{
	public ConfirmationPage conpage;
	public ProductCataloge productcat;
	public LandingPage landpage;
	
	
	@Given("I landed on Ecommerce page")
	public void I_landed_on_Ecommerce_page() throws IOException {
		landpage =launchApplication();
	}
	
	@Given("^Logged in with valid username (.+) and valid password (.+)$")
	public void logged_in_with_valid_username_and_valid_password(String username, String password )
	{
	         productcat=landpage.loginApplication(username, password );
	}
	
	@When("^I add product (.+) to the cart$")
	public void I_add_product_to_the_cart(String ProductName)
	{
		List<WebElement> productNames=productcat.getProductList();
		productcat.addProductToCart(ProductName);
	}
	
	@When("^Check out productName (.+) in cart and place the order$")
	public void check_out_productName_in_cart_and_place_the_order(String ProductName)
	{
		productcat.addProductToCart(ProductName);
		CartPage cpage=productcat.goToCart();
		Boolean match=cpage.checkingItemsAddedInCart(ProductName);
		Assert.assertTrue(match);
		CheckoutPage checkoutpage=cpage.clickonCheckout();
		checkoutpage.selectCountry("India");
		conpage= checkoutpage.submitOrder();
	}
	
	@Then("I verify the confirmation message {string}")
	public void I_verify_the_confirmation_message(String string)
	{
		String message=conpage.getConfirmationMessage();
		Assert.assertTrue(message.equalsIgnoreCase(string));
		driver.close();
	}

}
